<?php

defined('BASEPATH') OR exit('No direct script access allowed');

class transaksi extends CI_Controller {

      function __construct(){

            parent::__construct();

            $this->load->model('model_transaksi');
            $this->load->model('model_detailtransaksi');

      }

     

      public function index(){

            $data['trans']=$this->model_transaksi->show_barang();

            $this->load->view('transaksi/form_transaksi',$data);

      }
      public function hapus(){
            $id= $this->uri->segment(3);
            $this->db->where('id',$id);
            $this->db->delete('detail_transaksi');
            redirect('index.php/transaksi');
        }
}