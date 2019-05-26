<?php 
defined('BASEPATH') OR exit('No direct script access allowed');

/**
* 
*/
class model_detailharga extends CI_Model
{
	
	function __construct()
	{
		parent::__construct();
	}

	function get(){
		$query = $this->db->query('SELECT * FROM detail_transaksi');
        return $query->result();
	}
}
?>