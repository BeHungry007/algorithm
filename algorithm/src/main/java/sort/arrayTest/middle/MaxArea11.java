package sort.arrayTest.middle;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 盛最多水的容器
 */
public class MaxArea11 {

    public int maxArea(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length - 1;
        int tmp = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                tmp = height[left] * (right - left);
                left++;
            } else {
                tmp = height[right] * (right - left);
                right--;
            }
            area = Math.max(tmp, area);
        }
        return area;
    }

    public int maxArea1(int[] height) {
        int area = 0;
        int tmp = 0;
        int left = 0;
        int right = height.length;
        while (left < right) {
            if (height[left] < height[right]) {
                tmp = height[left] * (right - left);
                left++;
            } else {
                tmp = height[right] * (right - left);
                right--;
            }
            area = Math.max(tmp, area);
        }
        return area;
    }

    public static void main(String[] args) {
        int d = 1000000000;
        d++;
        String[] str = {"METER_ID","ASSET_NO","MP_ID","ORG_NO","AREA_NO","CONS_NO","BAUDRATE","COMM_NO","COMM_ADDR1","COMM_ADDR2","COMM_MODE","INST_LOC","INST_DATE","T_FACTOR","REF_METER_FLAG","REF_METER_ID","VALIDATE_CODE","MODULE_NO","MR_FACTOR","LAST_CHK_DATE","ROTATE_CYCLE","ROTATE_VALID_DATE","CHK_CYCLE","TMNL_ASSET_NO","FMR_ASSET_NO","REG_STATUS","REG_SN","ENCRYPT_TYPE","REG_PHASIC","REG_PHASIC_TIME","COLL_PORT","ERR_NO","ERR_CONTENT","CARRIER_WAVE_ID","CARRIER_WAVE_CHIP_MANUFACTURER","CARRIER_WAVE_TYPE","CARRIER_WAVE_VER","AREA_CODE","READ_FLAG","SET_READ_DATE","SET_STATUS_STAFF","CHG_STATUS_DATE","SET_STATUS_DATE","CHG_STATUS_STAFF"};

        System.out.println(d);
    }
}
