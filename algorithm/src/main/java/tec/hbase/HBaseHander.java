package tec.hbase;

//import com.cat.common.bean.EMsg;
//import com.cat.common.exception.RequestException;
//import com.cat.common.listener.RSystemConfig;
//import com.cat.common.properties.PropertiesUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class HBaseHander {

    private static volatile HBaseHander hBaseHander;

    protected Logger _logger = Logger.getLogger(this.getClass());
    /**
     * 连接
     */
    private static Connection connection;

    private static final String sep = "_";

    public static final String WD_yyyyMMddHHmm = "WD1002";

    /**
     * 小时维度
     */
    public static final String WD_yyyyMMddHH = "WD1003";

    /**
     * 日期维度
     */
    public static final String WD_yyyyMMdd = "WD1004";
    public static final String WD_yyyyMM_month = "WD1005";
    public static final String WD_yyyyMM = "WD1006";
    public static final String WD_yyyyMM_J = "WD1007";
    public static final String WD_yyyy = "WD1008";

    /**
     * hbase的表
     */
    private static final String table_name = "smk_app_quota";

    /**
     * 列
     */
    private static final String family = "quota";

    private HBaseHander() {
        if (connection == null) {
            synchronized (HBaseHander.class) {
                try {
                    Configuration conf = null;

                    conf = HBaseConfiguration.create();
                    //conf.set(TableOutputFormat.OUTPUT_TABLE, "testhbase");
//                        conf.set("hbase.zookeeper.quorum", "node01,node02,node03");

//                    String path = RSystemConfig.Home_Path + "hbase.properties";
//                    String path = "d://hbase.properties";
//                    _logger.info("fastdfsFile path="+path);
////                    Properties p = PropertiesUtil.getInstance().getProperties(path);
//
//                    conf.set("hbase.zookeeper.quorum", p.getProperty("hbase.zookeeper.quorum"));
//                    conf.set("hbase.zookeeper.property.clientPort",p.getProperty("hbase.zookeeper.property.clientPort"));
//                    conf.set("zookeeper.znode.parent", p.getProperty("zookeeper.znode.parent"));
//                    conf.set("hbase.client.retries.number", p.getProperty("hbase.client.retries.number"));
//                    conf.set("hbase.client.pause",p.getProperty("hbase.client.pause"));
//                    conf.set("zookeeper.recovery.retry.intervalmill", p.getProperty("zookeeper.recovery.retry.intervalmill"));
//                    conf.set("ipc.socket.timeout", p.getProperty("ipc.socket.timeout"));
//                    conf.set("hbase.rpc.timeout", p.getProperty("hbase.rpc.timeout"));
//                    conf.set("hbase.client.scanner.timeout.period", p.getProperty("hbase.client.scanner.timeout.period"));

                 /*   conf.set("hbase.zookeeper.quorum", "192.168.23.181,192.168.23.182,192.168.23.183");
                    conf.set("hbase.zookeeper.property.clientPort", "2181");
                    conf.set("zookeeper.znode.parent", "/hbase");
                    conf.set("hbase.client.retries.number", "3");
                    conf.set("hbase.client.pause", "100");
                    conf.set("zookeeper.recovery.retry.intervalmill", "200");
                    conf.set("ipc.socket.timeout", "2000");
                    conf.set("hbase.rpc.timeout", "2000");
                    conf.set("hbase.client.scanner.timeout.period", "500");*/

                    File workaround = new File(".");
                    System.getProperties().put("hadoop.home.dir",
                            workaround.getAbsolutePath());
                    new File("./bin").mkdirs();
                    try {
                        new File("./bin/winutils.exe").createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (connection == null) {
                        connection = ConnectionFactory.createConnection(conf);
                    }
                } catch (Exception e) {
                    _logger.info("初始化异常");
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 单例模式初始化
     * @return
     */
    public static HBaseHander getInstance() {
        if (hBaseHander == null) {
            synchronized (HBaseHander.class) {
                if (hBaseHander == null) {
                    hBaseHander = new HBaseHander();
                }
            }
        }
        return hBaseHander;
    }

    /**
     * 通过表名，rowKey ,family,columnName,获取指定Column数据
     */
    private String queryByColumnName(String tableName, String rowKey, String family, String columnName) {
        try {
            if (null == connection) {
//                throw new RequestException(EMsg.Fail, "HBASE系统异常");
            }
            Table table = connection.getTable(TableName.valueOf(tableName));
            Get get = new Get(rowKey.getBytes());
            Result result = table.get(get);
            byte[] str = result.getValue(family.getBytes(), columnName.getBytes());
            if (null == str) {
                return null;
            }
            table.close();
            return new String(str, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            _logger.info("queryByColumnName HBASE出现异常，异常信息为:" + e.toString());
        }
        return null;
    }

    /**
     * scan表数据，通过表名，列簇，columnName,时间的范围
     */
    private  Map<String, Object> queryByRange(String tableName,
                                              String rowKey, String family, String columnName, String startDate, String endDate) {
        ResultScanner results = null;
        Map<String, Object> retMap = new HashMap<String, Object>();
        try {
            if (null == connection) {
//                throw new RequestException(EMsg.Fail, "HBASE系统异常");
            }
            Table table = connection.getTable(TableName.valueOf(table_name));
            Scan scan = new Scan();
            scan.addColumn(family.getBytes(), columnName.getBytes());
            scan.setStartRow((rowKey + sep + startDate).getBytes());
            scan.setStopRow((rowKey + sep + endDate).getBytes());
            results = table.getScanner(scan);
            for (Result result : results) {
                for (Cell c : result.rawCells()) {
                    try {
                        String d = new String(CellUtil.cloneRow(c)).replace(rowKey + sep, "");
                        String v = new String(CellUtil.cloneValue(c));
                        retMap.put(d, Integer.parseInt(v));
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            table.close();
        } catch (IOException e) {
            e.printStackTrace();
            _logger.info("范围获取hbase数据出现异常，异常信息：" + e.toString());
        }
        return retMap;
    }

    // 格式化输出
    private static  void showCell(Result result) {
        Cell[] cells = result.rawCells();
        for (Cell cell : cells) {
            System.out.println("RowName:" + new String(CellUtil.cloneRow(cell)) + " ");
            System.out.println("Timetamp:" + cell.getTimestamp() + " ");
            System.out.println("column Family:" + new String(CellUtil.cloneFamily(cell)) + " ");
            System.out.println("row Name:" + new String(CellUtil.cloneQualifier(cell)) + " ");
            System.out.println("value:" + new String(CellUtil.cloneValue(cell)) + " ");
        }
    }

    /**
     * 查询一个时间范围内的埋点数据
     * @param appId
     * @param pointId
     * @param type  PV UV
     * @param startDate  开始时间
     * @param endDate 结束时间
     * @return
     */
    public  Map<String, Object> findDataForDayBury(String appId, String pointId, String type, String startDate, String endDate) {
        String key = WD_yyyyMMdd + sep + appId + sep + pointId;
        Map<String, Object> m = queryByRange(table_name, key, family, type, startDate, endDate);
        return m;
    }

    /**
     * 查询一个时间范围内的埋点数据
     * @param appId
     * @param pointId
     * @param type  PV UV
     * @param startDate  开始时间
     * @param endDate 结束时间
     * @return
     */
    public  Map<String, Object> findDataForHourBury(String appId, String pointId, String type, String startDate, String endDate) {
        String key = WD_yyyyMMddHH + sep + appId + sep + pointId;
        Map<String, Object> m = queryByRange(table_name, key, family, type, startDate, endDate);
        return m;
    }

}

