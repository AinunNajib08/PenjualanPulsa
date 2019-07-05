<?php defined('BASEPATH') or exit('No direct script access allowed');

class model_paketan extends CI_Model
{
    private $_table = "paketan";
    public $id;
    public $nama_operator
    public $kuota_paketan
    public $harga
    public $status
    public $no_tujuan
    ;

    public function rules()
    {
        
        return [
            [
                'field' => 'id',
                'label' => 'id',
                'rules' => 'required'
            ],

            [
                'field' => 'nama_operator',
                'label' => 'nama_operator',
                'rules' => 'required'
            ],

            [
                'field' => 'kuota_paketan',
                'label' => 'kuota_paketan',
                'rules' => 'required'
            ],

            [
                'field' => 'harga',
                'label' => 'harga',
                'rules' => 'required'
            ],

            [
                'field' => 'status',
                'label' => 'status',
                'rules' => 'required'
            ],

            [
                'field' => 'no_tujuan',
                'label' => 'no_tujuan',
                'rules' => 'required'
            ]
        ];
    }

    public function getAll()
    {
        return $this->db->get($this->_table)->result();
    }

    public function getById($id)
    {
        return $this->db->get_where($this->_table, ["id" => $id])->row();
    }

    public function save()
    {
        $post = $this->input->post();
        $this->id = $post["id"];
        $this->nama_operator = $post["nama_operator"];
        $this->kuota_paketan = $post["kuota_paketan"];
        $this->harga = $post["harga"];
        $this->status = $post["status"];
        $this->no_tujuan = $post["no_tujuan"];

        $this->db->insert($this->_table, $this);
    }


    public function delete($id_poli)
    {
        return $this->db->delete($this->_table, array("id" => $id));
    }
}
