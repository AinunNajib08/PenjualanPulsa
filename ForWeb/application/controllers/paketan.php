<?php

class paketan extends CI_Controller {

    function __construct() {
        parent:: __construct();
        $this->load->model('model_paketan');
    }

   function index() {
        $data["paketan"] = $this->model_paketan->getAll();
        $this->load->view('pembelian/form_paketan', $data );
      }

    function post() {
    
        if (isset($_POST['submit'])) {
             $data=array(
                "id_transaksi"   => $this->input->post('id'),
                "operator"       => $this->input->post('nama_operator'),
                "kuota_paketan"  => $this->input->post('kutoa_paketan'),
                "harga"          => $this->input->post('harga'),
                "no_tujuan"      => $this->input->post('no_tujuan')
                 );
                 $this->db->insert('paketan',$data);
                 $trans=array(
                    "id"   => $this->input->post('input_id'),
                     );
                     $this->db->insert('transaksi',$trans);
                $nominal = $this->input->post('input_harga');
                $paket = $this->input->post('input_kuota_paketan');
                $no = $this->input->post('input_no_tujuan');
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
        $this->db->delete('paketan');
        redirect('index.php/paketan');
    }
    public function paketan() {
        $this->load->view('pembelian/form_paketan');
    }
 
    
}
