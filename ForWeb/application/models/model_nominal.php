<?php

class Model_nominal extends CI_Model
{
	
	public function tampil_data()
	{
		$query="SELECT harga.nominal, harga.harga_jual
		FROM harga
		JOIN operator ON operator.id_transaksi = harga.id_transaksi";
		return $this->db->query($query);
	}

	function post($data)
	{
		$this->db->insert('harga',$data);
	}

	function get_one($id)
	{
		$param = array('nominal'=>$id);
		return $this->db->get_where('harga',$param);
	}

	function edit($data,$id)
	{
		$this->db->where('nominal',$id);
		$this->db->update('harga',$data);
	}

	function delete($id)
	{
		$this->db->where('nominal',$id);
		$this->db->delete('harga');
	}

	
}