<?php

defined('BASEPATH') or exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';

use Restserver\Libraries\REST_Controller;

class Pulsa extends REST_Controller
{

    function __construct($config = 'rest')
    {
        parent::__construct($config);
        $this->load->database();
    }


    function index_get()
    {
        $id = $this->get('kode_tujuan');
        if ($id == '') {
            $tujuan_pelayanan = $this->db->get('tujuan_pelayanan')->result();
        } else {
            $this->db->where('kode_tujuan', $id);
            $tujuan_pelayanan = $this->db->get('tujuan_pelayanan')->result();
        }
        $this->response($tujuan_pelayanan, 200);
    }

    function index_post()
    {
        $data = array(
            'id_transaksi'           => $this->post('id_transaksi'),
            'operator'          => $this->post('operator'),
            'nominal'    => $this->post('nominal'),
            'harga_jual' => $this->post('harga_jual'),
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
