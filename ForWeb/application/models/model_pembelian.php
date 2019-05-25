<?php
class Model_pembelian extends CI_Model
{
	function post($data)
	{
		$this->db->insert('transaksi',$data);
	}

	function get_one($id)
	{
		$param = array('id_transaksi'=>$id);
		return $this->db->get_where('transaksi',$param);
	}


}