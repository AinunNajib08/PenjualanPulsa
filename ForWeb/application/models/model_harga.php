<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');
class model_harga extends CI_Model {
  public function view(){
    return $this->db->get('pulsa')->result();
  }
  

  public function view_by($hrg){
    $this->db->where('harga', $hrg);
    return $this->db->get('pulsa')->row();
  }
  

  public function validation($mode){
    $this->load->library('form_validation'); // Load library form_validation untuk proses validasinya
    
    // Tambahkan if apakah $mode save atau update
    // Karena ketika update, NIS tidak harus divalidasi
    // Jadi NIS di validasi hanya ketika menambah data siswa saja
    if($mode == "save")
    $this->form_validation->set_rules('input_nominal', 'nominal', 'required');
    $this->form_validation->set_rules('input_harga_jual', 'harga_jual', 'required');
      
    if($this->form_validation->run()) // Jika validasi benar
      return TRUE; // Maka kembalikan hasilnya dengan TRUE
    else // Jika ada data yang tidak sesuai validasi
      return FALSE; // Maka kembalikan hasilnya dengan FALSE
  }
  
  public function save(){
    $data = array(
      "nominal" => $this->input->post('input_nominal'),
      "harga_jual" => $this->input->post('input_harga_jual')
    );
    
    $this->db->insert('detail_transaksi', $data); // Untuk mengeksekusi perintah insert data
  }
  
  public function edit($hrg){
    $data = array(
		"nominal" => $this->input->post('input_nominal'),
		"harga_jual" => $this->input->post('input_harga_jual')
    );
    
    $this->db->where('harga', $hrg);
    $this->db->update('pulsa', $data); // Untuk mengeksekusi perintah update data
  }
  

  public function delete($hrg){
    $this->db->where('harga', $hrg);
    $this->db->delete('pulsa'); // Untuk mengeksekusi perintah delete data
  }
}