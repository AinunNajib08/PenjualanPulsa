<?php

class Pembelian extends CI_Controller {

    function __construct() {
        parent:: __construct();
        $this->load->model('model_harga');
        $this->load->model('model_detailtransaksi');
        $this->load->model('model_operator');
        $this->load->model('model_detailharga');
    }

   function index() {
        $data['operator'] = $this->model_operator->get();
        $data['harga'] = $this->model_detailharga->get();
        $this->load->view('pembelian/form_pembelian',$data);
      }

    function post() {
        if (isset($_POST['submit'])) {
             $data=array(
                "id_transaksi"   => $this->input->post('input_id_transaksi'),
                "operator"       => $this->input->post('input_operator'),
                "nominal"        => $this->input->post('input_nominal'),
                "harga_jual"     => $this->input->post('input_harga_jual'),
                "no_tujuan"      => $this->input->post('input_no_tujuan')
                 );
                 $this->db->insert('detail_transaksi',$data);
                 redirect('index.php/pembelian');
        } else {
            $this->load->view('pembelian/form_pembelian');
        }
    }
    
    public function cancel() {
        $id= $this->uri->segment(3);
        $this->db->where('id',$id);
        $this->db->delete('detail_transaksi');
        redirect('index.php/pembelian');
    }
    public function pembelian() {
        $this->load->view('pembelian/form_pembelian');
    }
 
    
}
