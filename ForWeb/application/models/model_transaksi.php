<?php

class model_transaksi extends CI_Model{

      function show_barang(){

            $hasil=$this->db->query("SELECT * FROM detail_trans");

            return $hasil;

      }    

}