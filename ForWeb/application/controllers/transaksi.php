<?php

defined('BASEPATH') OR exit('No direct script access allowed');

class transaksi extends CI_Controller {

      function __construct(){

            parent::__construct();

            $this->load->model('model_transaksi');

      }

     

      public function index(){

            $data['trans']=$this->model_transaksi->show_barang();

            $this->load->view('transaksi/form_transaksi',$data);

      }

}