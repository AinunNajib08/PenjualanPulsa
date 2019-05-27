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
                 $trans=array(
                    "id_transaksi"   => $this->input->post('input_id_transaksi'),
                    "tanggal"       => $this->input->post('input_tanggal'),
                     );
                     $this->db->insert('transaksi',$trans);
                $no = $this->input->post('input_no_tujuan');
                $nominal = $this->input->post('input_nominal');
                $sms = array("no" =>  "3636", "pesan" => "BeliPulsa Rp." .$nominal." Nomor ".$no); 
                $data_string = json_encode($sms);
                $ch = curl_init('http://192.168.43.1:8000'); 
                curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "POST"); 
                curl_setopt($ch, CURLOPT_POSTFIELDS, $data_string); 
                curl_setopt($ch, CURLOPT_RETURNTRANSFER, true); 
                curl_setopt($ch, CURLOPT_HTTPHEADER, array(    
                'Content-Length: ' . strlen($data_string))
                );
                $result = curl_exec($ch);
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
