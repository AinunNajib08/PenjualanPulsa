package com.najib.gatewayserver;

public class konfigurasi {

        public static final String URL_ADD="http://192.168.1.7/crud/Android/pegawai/tambahPgw.php";
        public static final String URL_GET_ALL = "https://192.168.43.1/crud/Android/pegawai/tampilSemuaPgw.php";
        public static final String URL_GET_EMP = "http://192.168.1.7/crud/Android/pegawai/tampilPgw.php?id=";
        public static final String URL_UPDATE_EMP = "http://192.168.1.7/crud/Android/pegawai/updatePgw.php";
        public static final String URL_DELETE_EMP = "http://dissentient-keyword.000webhostapp.com/Android/pegawai/hapusPgw.php?id=";

        //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
        public static final String KEY_EMP_ID = "id";
        public static final String KEY_EMP_NOMOR = "nomor";
        public static final String KEY_EMP_PROVIDER = "provider"; //desg itu variabel untuk posisi
        public static final String KEY_EMP_JUMLAH = "jumlah"; //salary itu variabel untuk gajih
        public static final String KEY_EMP_STATUS = "status"; //salary itu variabel untuk gajih

        //JSON Tags
        public static final String TAG_JSON_ARRAY="result";
        public static final String TAG_ID = "id";
        public static final String TAG_NOMOR = "nomor";
        public static final String TAG_PROVIDER = "provider";
        public static final String TAG_JUMLAH = "jumlah";
        public static final String TAG_STATUS = "status";

        //ID karyawan
        //emp itu singkatan dari Employee
        public static final String EMP_ID = "emp_id";
    }
