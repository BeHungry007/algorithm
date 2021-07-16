package utils;

import org.junit.Test;
import utils.Node;

public class EStest implements Cloneable{

    public static void main(String[] args) {
        String s = "'bitguard-sensor-userinput-v5.0-2018.12', 'bitguard-sensor-userinput-v5.0-2019.01', 'bitguard-sensor-userinput-v5.0-2019.09.24', 'bitguard-sensor-userinput-v5.0-2019.09.25', 'bitguard-sensor-userinput-v5.0-2019.09.26', 'bitguard-sensor-userinput-v5.0-2019.09.28', 'bitguard-sensor-userinput-v5.0-2019.09.29', 'bitguard-sensor-userinput-v5.0-2019.10.01', 'bitguard-sensor-userinput-v5.0-2019.10.09', 'bitguard-sensor-userinput-v5.0-2019.10.10', 'bitguard-sensor-userinput-v5.0-2019.10.11', 'bitguard-sensor-userinput-v5.0-2019.10.12', 'bitguard-sensor-userinput-v5.0-2019.10.15', 'bitguard-sensor-userinput-v5.0-2020.01.23', 'bitguard-sensor-userinput-v5.0-2020.03.22', 'bitguard-sensor-userinput-v5.0-2020.04.07', 'bitguard-sensor-userinput-v5.0-2020.11.19', 'bitguard-sensor-userinput-v5.0-2020.11.20', 'bitguard-sensor-userinput-v5.0-2020.11.23', 'bitguard-sensor-userinput-v5.0-2020.11.24', 'bitguard-sensor-userinput-v5.0-2020.11.26', 'bitguard-sensor-userinput-v5.0-2020.11.27', 'bitguard-sensor-userinput-v5.0-2020.11.30', 'bitguard-sensor-userinput-v5.0-2020.12.01', 'bitguard-sensor-userinput-v5.0-2020.12.02', 'bitguard-sensor-userinput-v5.0-2020.12.03', 'bitguard-sensor-userinput-v5.0-2020.12.04', 'bitguard-sensor-userinput-v5.0-2020.12.07', 'bitguard-sensor-userinput-v5.0-2020.12.08', 'bitguard-sensor-userinput-v5.0-2020.12.09', 'bitguard-sensor-userinput-v5.0-2020.12.10', 'bitguard-sensor-userinput-v5.0-2020.12.11', 'bitguard-sensor-userinput-v5.0-2020.12.14', 'bitguard-sensor-userinput-v5.0-2020.12.15', 'bitguard-sensor-userinput-v5.0-2020.12.16', 'bitguard-sensor-userinput-v5.0-2020.12.17', 'bitguard-sensor-userinput-v5.0-2020.12.18', 'bitguard-sensor-userinput-v5.0-2020.12.21', 'bitguard-sensor-userinput-v5.0-2020.12.22', 'bitguard-v5.0-2018.11', 'bitguard-v5.0-2018.12', 'bitguard-v5.0-2019.01', 'bitguard-v5.0-2019.02', 'bitguard-v5.0-2019.04', 'bitguard-v5.0-2019.08', 'bitguard-v5.0-2019.09.16', 'bitguard-v5.0-2019.09.17', 'bitguard-v5.0-2019.09.18', 'bitguard-v5.0-2019.09.20', 'bitguard-v5.0-2019.09.24', 'bitguard-v5.0-2019.09.25', 'bitguard-v5.0-2019.09.26', 'bitguard-v5.0-2019.09.27', 'bitguard-v5.0-2019.09.28', 'bitguard-v5.0-2019.09.29', 'bitguard-v5.0-2019.09.30', 'bitguard-v5.0-2019.10.01', 'bitguard-v5.0-2019.10.05', 'bitguard-v5.0-2019.10.06', 'bitguard-v5.0-2019.10.07', 'bitguard-v5.0-2019.10.08', 'bitguard-v5.0-2019.10.10','bitguard-v5.0-2019.10.12', 'bitguard-v5.0-2019.10.13', 'bitguard-v5.0-2019.10.14', 'bitguard-v5.0-2019.10.16', 'bitguard-v5.0-2019.11.26', 'bitguard-v5.0-2020.04.15', 'bitguard-v5.0-2020.04.19', 'bitguard-v5.0-2020.06.14', 'bitguard-v5.0-2020.11.19', 'bitguard-v5.0-2020.11.20', 'bitguard-v5.0-2020.11.21', 'bitguard-v5.0-2020.11.22', 'bitguard-v5.0-2020.11.23', 'bitguard-v5.0-2020.11.24', 'bitguard-v5.0-2020.11.25', 'bitguard-v5.0-2020.11.26', 'bitguard-v5.0-2020.11.27', 'bitguard-v5.0-2020.11.28', 'bitguard-v5.0-2020.11.29', 'bitguard-v5.0-2020.11.30', 'bitguard-v5.0-2020.12.01', 'bitguard-v5.0-2020.12.02', 'bitguard-v5.0-2020.12.03', 'bitguard-v5.0-2020.12.04', 'bitguard-v5.0-2020.12.05', 'bitguard-v5.0-2020.12.06', 'bitguard-v5.0-2020.12.07', 'bitguard-v5.0-2020.12.08', 'bitguard-v5.0-2020.12.09', 'bitguard-v5.0-2020.12.10', 'bitguard-v5.0-2020.12.11', 'bitguard-v5.0-2020.12.12', 'bitguard-v5.0-2020.12.13', 'bitguard-v5.0-2020.12.14', 'bitguard-v5.0-2020.12.15', 'bitguard-v5.0-2020.12.16', 'bitguard-v5.0-2020.12.17', 'bitguard-v5.0-2020.12.18', 'bitguard-v5.0-2020.12.19', 'bitguard-v5.0-2020.12.20', 'bitguard-v5.0-2020.12.21', 'bitguard-v5.0-2020.12.22', 'logstash-v5.0-2018.11', 'logstash-v5.0-2018.12', 'logstash-v5.0-2019.02', 'logstash-v5.0-2019.04', 'logstash-v5.0-2019.06', 'logstash-v5.0-2019.09.20', 'logstash-v5.0-2019.09.22', 'logstash-v5.0-2019.09.23', 'logstash-v5.0-2019.09.24', 'logstash-v5.0-2019.09.25', 'logstash-v5.0-2019.09.26', 'logstash-v5.0-2019.09.28', 'logstash-v5.0-2019.09.29', 'logstash-v5.0-2019.09.30', 'logstash-v5.0-2019.10', 'logstash-v5.0-2019.10.01', 'logstash-v5.0-2019.10.02', 'logstash-v5.0-2019.10.03', 'logstash-v5.0-2019.10.05', 'logstash-v5.0-2019.10.07', 'logstash-v5.0-2020.11.19'";
        String s1 = "red   open bitguard-v5.0-2020.12.07                  wfJDiIeRRCaN2dQldsCvPw 2 1\n" +
                "red   open logstash-v5.0-2019.09.22                  U8hUBD1OSUqF3aKsnZ2kyQ 2 1      182      0  599.8kb  299.9kb\n" +
                "red   open bitguard-v5.0-2018.12                     sPy1rCjRQZiD3hWFtKcYig 2 1     8486      0    6.7mb    3.3mb\n" +
                "red   open bitguard-v5.0-2019.08                     nttVN3tfQUCkvgfEfBa86w 2 1    31724      0   25.7mb   12.8mb\n" +
                "red   open logstash-v5.0-2019.09.29                  88HsmlziQ3ulJ68ey774XQ 2 1    13324      0   19.8mb    9.9mb\n" +
                "red   open bitguard-v5.0-2020.12.09                  U5XAmZVjQcyj_lgPbiqztw 2 1\n" +
                "red   open bitguard-v5.0-2020.12.04                  K89-xh0JRpKXCpHkkbhLew 2 1\n" +
                "red   open bitguard-v5.0-2019.10.05                  pPhhkUj0S9ukC-fQ5x-4Wg 2 1     8741      0    6.4mb    3.2mb\n" +
                "red   open bitguard-v5.0-2020.12.02                  VzrlQzUNS1uAXotkJKvSWg 2 1\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.12.11 fTzttG4dQ1CqBxEVflieCg 2 1\n" +
                "red   open bitguard-v5.0-2020.12.08                  KPmP7hbPQz-g9V_E9AQPuQ 2 1\n" +
                "red   open bitguard-v5.0-2020.12.14                  5MU1zRiBRBKSNdMQFONBpA 2 1      133      0   59.6kb   29.8kb\n" +
                "red   open bitguard-v5.0-2020.12.15                  mj3jhaGNRymz6KYQvFukig 2 1      150      0   66.8kb   33.4kb\n" +
                "red   open logstash-v5.0-2019.10.02                  Z97REMRMS92sMLdH21NrBg 2 1      192      0    881kb  440.5kb\n" +
                "red   open bitguard-v5.0-2019.10.12                  NOXJ1ErgTcqCa4bDbrjH_Q 2 1     9052      0    7.2mb    3.6mb\n" +
                "red   open bitguard-v5.0-2019.11.26                  lvO_zkE4QhezE25rVnP7Tw 2 1     1484      0    1.1mb  607.7kb\n" +
                "red   open bitguard-v5.0-2020.11.28                  nNF1JrCDSumLogjfeU6GYA 2 1\n" +
                "red   open bitguard-v5.0-2019.09.28                  LtB_LUJNQiuKPKub43hidg 2 1     8780      0    6.5mb    3.2mb\n" +
                "red   open bitguard-v5.0-2019.10.08                  kbLtmvD2QzCvZGsWX-cwbA 2 1     9159      0    7.3mb    3.6mb\n" +
                "red   open bitguard-sensor-userinput-v5.0-2019.01    XYmEpWOWSSeL4uJixZ-lfA 2 1        1      0   35.3kb   17.6kb\n" +
                "red   open logstash-v5.0-2019.10.05                  AJvFe9goRSij55P15T8D8g 2 1      171      0  672.4kb  336.2kb\n" +
                "red   open logstash-v5.0-2019.09.24                  fJi5nZBpTriSqusd5FGThw 2 1     1818      0    3.2mb    1.6mb\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.12.21 n4b-bafpTQWsyEyxlRCGYQ 2 1       12      0   41.7kb   20.8kb\n" +
                "red   open bitguard-v5.0-2019.10.14                  MK4XcAydQg-o-2HGzjv64Q 2 1    10921      0    8.9mb    4.4mb\n" +
                "red   open bitguard-v5.0-2020.11.20                  xeokvi5wRLCDzdovjO3sHg 2 1\n" +
                "red   open bitguard-v5.0-2020.04.19                  PsOVeVngT7CYzgHW71OCfg 2 1     2764      0    3.4mb    1.7mb\n" +
                "red   open bitguard-v5.0-2020.12.22                  mqGJgKMPRQGuePRWr3tj8A 2 1       26      0   22.7kb   11.3kb\n" +
                "red   open bitguard-v5.0-2020.12.13                  jRw3DSEqQAGxmtuVRDRKSw 2 1\n" +
                "red   open bitguard-v5.0-2020.12.11                  bhcugED6RrmhYoo07orlaA 2 1\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.11.27 zDvNuZoMS-Sk72B6l1rVdg 2 1\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.12.16 JZr8WTsrQta6Phe1EbREkg 2 1      635      0  368.9kb  184.4kb\n" +
                "red   open logstash-v5.0-2019.10.07                  P_RfkoNvSuOvkZMxyHE9_w 2 1      155      0  628.7kb  314.3kb\n" +
                "red   open bitguard-sensor-userinput-v5.0-2019.10.15 UFxznid-QCWstlA8ZAWegg 2 1      285      0  258.2kb  129.1kb\n" +
                "red   open logstash-v5.0-2019.09.25                  e3nDjsn0Ts2EV3eVsPso-g 2 1     1855      0    3.7mb    1.8mb\n" +
                "red   open logstash-v5.0-2018.11                     tkq6mR_5R66ErgnHhZVr7w 2 1    18579      0   42.3mb   21.1mb\n" +
                "red   open bitguard-v5.0-2019.10.13                  I32WvQXlQ2iVeASmjeb75g 2 1     8956      0    6.9mb    3.4mb\n" +
                "red   open bitguard-v5.0-2020.12.20                  eIzTwHMPSnerFZwN8b6LeA 2 1      140      0   62.7kb   31.3kb\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.01.23 bde_nP74Sp2LNR0evhjasg 2 1       84      0   96.4kb   48.2kb\n" +
                "red   open logstash-v5.0-2019.09.26                  12t_piBjTkaSKUdeIXPsdA 2 1      839      0    2.2mb    1.1mb\n" +
                "red   open bitguard-v5.0-2020.11.23                  lDxRPP-hSve9QzYO0Pa8_A 2 1\n" +
                "red   open bitguard-v5.0-2020.11.29                  9qnAenMhTs26TnkiBDKhog 2 1\n" +
                "red   open logstash-v5.0-2019.09.20                  -VST0cz3SReKIT0RBqqlig 2 1      201      0  635.2kb  317.6kb\n" +
                "red   open bitguard-v5.0-2020.06.14                  6ySkrOZURM6uSuZB6-8pcQ 2 1     1018      0      1mb  521.7kb\n" +
                "red   open bitguard-v5.0-2020.11.22                  WQygxI9ESgCSZ4bik7-4zA 2 1\n" +
                "red   open logstash-v5.0-2019.02                     o1-bUK_GS_-nGbCvj8EQ7g 2 1     8580      0     17mb    8.5mb\n" +
                "red   open bitguard-v5.0-2020.11.25                  XEle0K5FRsuDqefwyU8N-A 2 1\n" +
                "red   open bitguard-v5.0-2019.09.29                  jhHwuQvbRiqCraYD1w4mUQ 2 1     9451      0    7.5mb    3.7mb\n" +
                "red   open bitguard-v5.0-2019.10.07                  jn9l503mQpieB5t7cuMI9g 2 1     8693      0    6.3mb    3.1mb\n" +
                "red   open bitguard-v5.0-2020.12.16                  J76shlyASXSQM-UAyv-3HA 2 1      180      0  119.8kb   59.9kb\n" +
                "red   open bitguard-v5.0-2018.11                     cKFpj2kCSuCulLxs7UF0hQ 2 1      672      0  225.4kb  112.7kb\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.12.18 8W9l8pYWQDW-eGQKBiShRw 2 1      183      0  152.3kb   76.1kb\n" +
                "red   open bitguard-v5.0-2019.10.10                  rH35PGGgQSiqzYQWwb5Y9A 2 1     8885      0    6.5mb    3.2mb\n" +
                "red   open logstash-v5.0-2019.06                     oNNASmcUTwSLDIVC-u3afw 2 1    32681      0   60.6mb   30.3mb\n" +
                "red   open logstash-v5.0-2020.11.19                  y_8IeB7kSJ-khUwVhyG6xw 2 1\n" +
                "red   open bitguard-v5.0-2020.12.06                  SPvmR8PdQm2xYEOhKNPoCw 2 1\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.12.07 EQUOOZNPR5C4XNO5HpeKWQ 2 1\n" +
                "red   open bitguard-sensor-userinput-v5.0-2019.10.12 9JxM9ljQQMelzYDyUxTZvA 2 1      371      0  317.8kb  158.9kb\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.12.08 mh9zOQPgSXSFy4Gn2E5qNQ 2 1\n" +
                "red   open bitguard-v5.0-2020.11.30                  c-V-yzypQqKIX6tMYEeWSg 2 1\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.12.03 D9gEms40R3ukHOA3fPHJ8A 2 1\n" +
                "red   open bitguard-v5.0-2020.12.21                  ftaji9spS0Kt8-pkeD0CdA 2 1      129      0   57.8kb   28.9kb\n" +
                "red   open logstash-v5.0-2019.09.30                  JCm5dxdtRrCVcLsfYiqIFA 2 1      285      0 1022.7kb  511.3kb\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.12.15 SwKoZdsFS-W2RBJ10qKxZQ 2 1       87      0    105kb   52.5kb\n" +
                "red   open bitguard-v5.0-2020.11.24                  IDz3-NtdRtG_Tr4LHB7s1g 2 1\n" +
                "red   open bitguard-sensor-userinput-v5.0-2019.10.01 PRAFbMSjQe66SZBq7hPxTg 2 1       23      0   58.5kb   29.2kb\n" +
                "red   open bitguard-sensor-userinput-v5.0-2019.09.25 qyZn5pqMR_6QAtGsdndlwg 2 1      143      0  196.8kb   98.4kb\n" +
                "red   open bitguard-v5.0-2019.10.01                  Q9w_5gcVQEePf-NOd-6kig 2 1     8761      0    6.3mb    3.1mb\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.11.20 oNFvmW7dSfC-vZFZIuGWVg 2 1\n" +
                "red   open logstash-v5.0-2019.10.01                  t2qFrcqWR-a2arkoanrl-A 2 1      156      0  665.1kb  332.5kb\n" +
                "red   open bitguard-v5.0-2020.12.17                  Am93uqKNTBGAMRj7YuJ39g 2 1      136      0   60.5kb   30.2kb\n" +
                "red   open bitguard-v5.0-2019.09.30                  dLoezQ5gRlW5B9DNJyMVhw 2 1     8795      0    6.5mb    3.2mb\n" +
                "red   open logstash-v5.0-2019.09.23                  dZFTOaJZT9eC6nClP-mR5w 2 1     7946      0   10.7mb    5.3mb\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.12.09 yR_skYZIRiydGYa0-_iRug 2 1\n" +
                "red   open logstash-v5.0-2019.10.03                  9wH79X_oTFaNuLQx_VxQdQ 2 1      154      0  610.5kb  305.2kb\n" +
                "red   open bitguard-v5.0-2020.12.01                  MISe1SS7R5iNIw7DfAK1Ng 2 1\n" +
                "red   open logstash-v5.0-2019.04                     3Z7kC5mCRwq0CGrCt-HrgA 2 1    28662      0   54.1mb     27mb\n" +
                "red   open bitguard-v5.0-2020.11.27                  CL9whDwBQhySUCbo8WqRMQ 2 1\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.11.26 KUVFdP8lRwuFR2XqWi-3Ww 2 1\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.03.22 lFfXIpfGRoud0ifbpomufw 2 1      256      0  255.7kb  127.8kb\n" +
                "red   open bitguard-v5.0-2020.11.21                  mtstWLMUTwK_BXiSkwPVJg 2 1\n" +
                "red   open logstash-v5.0-2019.10                     ks0tsLRhTr-JUJv4USqhOQ 2 1     1119      0  931.9kb  465.9kb\n" +
                "red   open logstash-v5.0-2018.12                     tBnQsNfwRTua99T0MumT2Q 2 1   342909      0    790mb    395mb\n" +
                "red   open bitguard-v5.0-2020.12.19                  wFT4sn-zQU-CZkDqUQaQVg 2 1      136      0   60.4kb   30.2kb\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.11.30 EyTZXDotTNylVEit3nQz0w 2 1\n" +
                "red   open bitguard-v5.0-2019.09.27                  q_dDVGLqSW6FRhX45lSUFQ 2 1     8668      0    6.7mb    3.3mb\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.04.07 Jx9Z_nB4TRaHHxkTgv9SOQ 2 1      724      0  582.2kb  291.1kb\n" +
                "red   open bitguard-v5.0-2019.09.20                  07nFeAKqRhWoJt3rUPB-Hg 2 1     2619      0    2.5mb    1.2mb\n" +
                "red   open bitguard-v5.0-2019.01                     UH8m4QqdRTeEMq3nRHmARQ 2 1    11503      0     10mb      5mb\n" +
                "red   open bitguard-v5.0-2019.10.16                  qEz5Da6pQyqwCKMUmswWgQ 2 1     9451      0    7.8mb    3.9mb\n" +
                "red   open bitguard-sensor-userinput-v5.0-2019.10.11 HGeAP-AoSG6rb2yph3saWg 2 1      138      0  197.7kb   98.8kb\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.12.14 B_d_pQWTTvmshg9DTQZ7RA 2 1       95      0  115.4kb   57.7kb\n" +
                "red   open bitguard-v5.0-2019.10.06                  23ypT2IcRFSCH5JJK1aIQg 2 1     8779      0    6.5mb    3.2mb\n" +
                "red   open bitguard-v5.0-2020.12.05                  Ezjg-pIgRgWf0Ws48U_Hrw 2 1\n" +
                "red   open bitguard-sensor-userinput-v5.0-2019.10.10 _puH-_WkTZCp82-sB-kayg 2 1      337      0  324.7kb  162.3kb\n" +
                "red   open bitguard-v5.0-2019.02                     uE45hjGjSYWnx4BkstrjBQ 2 1    13749      0   11.6mb    5.8mb\n" +
                "red   open bitguard-v5.0-2019.09.17                  AjnZJK6UR9mIrEF2txKbfg 2 1      762      0  883.7kb  441.9kb\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.12.10 BgLhF5gcR2eE-18vzvxxsw 2 1\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.11.19 jXKesAN8RuWN4aWoASH2Yw 2 1\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.11.24 RtKrDVFgQgaKiiJdmdqziw 2 1\n" +
                "red   open bitguard-v5.0-2019.09.25                  goXLu_D1TiOFsl9vIOseLQ 2 1     6031      0    5.1mb    2.5mb\n" +
                "red   open bitguard-sensor-userinput-v5.0-2019.09.24 Yi33Z0RvROeaD816WZaqxQ 2 1      307      0  338.3kb  169.1kb\n" +
                "red   open bitguard-v5.0-2019.09.26                  biSUDBeIR5Oz6-FMgfd4_g 2 1     8231      0      7mb    3.5mb\n" +
                "red   open bitguard-sensor-userinput-v5.0-2019.10.09 qpJVa9QIR3KPKh_0njPPDA 2 1      160      0  256.1kb    128kb\n" +
                "red   open bitguard-sensor-userinput-v5.0-2019.09.28 F_03wYK-TgS5awGmpTxh3g 2 1        9      0   41.6kb   20.8kb\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.11.23 -5zHZxfUQvOt1AHR9P9z8A 2 1\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.12.01 GHZIZGCwRYeqvK9H10baaQ 2 1\n" +
                "red   open bitguard-v5.0-2019.09.18                  Je9PYJ11R-u2iVHnkok99A 2 1     1490      0    1.6mb  859.3kb\n" +
                "red   open bitguard-v5.0-2019.09.16                  XzEfB5otQU-WbdZAq-owtQ 2 1     1396      0    1.4mb  723.6kb\n" +
                "red   open bitguard-v5.0-2020.12.10                  dCDyGXBKSdKPFampLDkIqQ 2 1\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.12.04 zrjhsIXJTIyAMvIN9Pg5fA 2 1\n" +
                "red   open bitguard-v5.0-2019.04                     4T66YKO2T9-cW-gwIzB1sA 2 1   104259      0   76.7mb   38.3mb\n" +
                "red   open bitguard-v5.0-2020.11.26                  iMwPmewxQEiUV4yKfGnvUA 2 1\n" +
                "red   open bitguard-v5.0-2020.12.12                  tBpESH5fThOCwv91xAJMJw 2 1\n" +
                "red   open bitguard-sensor-userinput-v5.0-2018.12    5JLILfBlTBu_fOQztKUNxA 2 1       33      0   67.3kb   33.6kb\n" +
                "red   open bitguard-sensor-userinput-v5.0-2019.09.29 cI649hD3Qz6mjC-sl3q72A 2 1      626      0  480.1kb    240kb\n" +
                "red   open bitguard-sensor-userinput-v5.0-2019.09.26 5S23nHXUS_6i5O_5HdcoxA 2 1      250      0  308.8kb  154.4kb\n" +
                "red   open bitguard-v5.0-2019.09.24                  YFgQxjRjQBy7GkC35PxCOw 2 1     7294      0    6.1mb      3mb\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.12.02 pXpmIP6TQn-H7PE_DtXDWQ 2 1\n" +
                "red   open bitguard-v5.0-2020.12.03                  CRfSuHB7QnSSmWcPFaIUEg 2 1\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.12.22 oGbbkaB-SAqzkuxY_dFzyQ 2 1       19      0   47.4kb   23.7kb\n" +
                "red   open logstash-v5.0-2019.09.28                  B337kPyWT9aD-r6XBfgk-Q 2 1      530      0    1.3mb  668.6kb\n" +
                "red   open bitguard-sensor-userinput-v5.0-2020.12.17 E-X7CBs_RIGBnSSMgEtemw 2 1       23      0   54.7kb   27.3kb\n" +
                "red   open bitguard-v5.0-2020.11.19                  D5PSsdlWSWqmQfG7Hqt0KQ 2 1\n" +
                "red   open bitguard-v5.0-2020.12.18                  gFLkNx3dQ-ixHtS1pyCW_Q 2 1      182      0  127.7kb   63.8kb\n" +
                "red   open bitguard-v5.0-2020.04.15                  bXmfmnC3TFOexhNcSp7EdQ 2 1     1616      0    2.1mb      1mb";

        String[] split = s.split(",");
        int count = 0;
        for (String s2 : split) {
            String s3 = s2.replaceAll(" ", "");
            if (s1.indexOf(s3.substring(1, s3.length() - 1)) > 0) {
                System.out.println(s3.substring(1, s3.length() - 1));
                count++;
            }
        }
        System.out.println(count);
        System.out.println(split.length);
//        double i = 50000;
//
//        double count = i;
//        for (int j = 0; j < 12 * 19; j++) {
//            i = i * 1.005 + 1500;
//            count += 1500;
//        }
//        System.out.println(i);
//        System.out.println(count);
    }
}