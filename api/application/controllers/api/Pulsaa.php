<?php

defined('BASEPATH') or exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';

use Restserver\Libraries\REST_Controller;

class Pulsaa extends REST_Controller
{

    function __construct($config = 'rest')
    {
        parent::__construct($config);
        $this->load->database();
    }


    function index_get()
    {

        $query = $this->db->get('detail_trans')->result();
        $this->response(array("result" => $query, 200));
    }

    function index_post()
    {
        $nominal = $this->post('nominal');
        $harga_jual = 0;

        if ($nominal == 5000) {
            $harga_jual = 6000;
        } else if ($nominal == 10000) {
            $harga_jual = 11000;
        } else if ($nominal == 15000) {
            $harga_jual == 160000;
        } else {
            $harga_jual == 210000;
        }
        $data = array(

            'id_transaksi'           => $this->post('id_transaksi'),
            'operator'          => $this->post('operator'),
            'nominal'    => $nominal,
            'harga_jual' => $harga_jual,
            'no_tujuan' => $this->post('no_tujuan'),
            'status' => "Berhasil"
        );
        $insert = $this->db->insert('detail_trans', $data);
        if ($insert) {
            $this->response($data, 200);
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }
}
