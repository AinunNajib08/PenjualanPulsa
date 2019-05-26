<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');
class model_detailtransaksi extends CI_Model {
  public function view(){
    return $this->db->get('pulsa')->result();
  }
  

  public function view_by($pls){
    $this->db->where('detail_transaksi', $pls);
    return $this->db->get('pulsa')->row();
  }
  

  public function validation($mode){
    $this->load->library('form_validation'); // Load library form_validation untuk proses validasinya
    
    // Tambahkan if apakah $mode save atau update
    // Karena ketika update, NIS tidak harus divalidasi
    // Jadi NIS di validasi hanya ketika menambah data siswa saja
    if($mode == "save")
    $this->form_validation->set_rules('input_id_transaksi', 'id_transaksi', 'required');
    $this->form_validation->set_rules('input_operator', 'operator', 'required');
    $this->form_validation->set_rules('input_nominal', 'nominal', 'required');
    $this->form_validation->set_rules('input_harga_jual', 'harga_jual', 'required');
    $this->form_validation->set_rules('input_no_tujuan', 'no_tujuan', 'required|numeric|max_length[13]');
      
    if($this->form_validation->run()) // Jika validasi benar
      return TRUE; // Maka kembalikan hasilnya dengan TRUE
    else // Jika ada data yang tidak sesuai validasi
      return FALSE; // Maka kembalikan hasilnya dengan FALSE
  }
  
  public function save(){
    $data = array(
      "id_transaksi" => $this->input->post('input_id_transaksi'),
      "operator" => $this->input->post('input_operator'),
      "nominal" => $this->input->post('input_nominal'),
      "harga_jual" => $this->input->post('input_harga_jual'),
      "no_tujuan" => $this->input->post('input_no_tujuan')
    );
    
    $this->db->insert('detail_transaksi', $data); // Untuk mengeksekusi perintah insert data
  }
  
  public function edit($pls){
    $data = array(
        "id_transaksi" => $this->input->post('input_id_transaksi'),
        "operator" => $this->input->post('input_operator'),
        "nominal" => $this->input->post('input_nominal'),
        "harga_jual" => $this->input->post('input_harga_jual'),
        "no_tujuan" => $this->input->post('input_no_tujuan')
    );
    
    $this->db->where('detail_transaksi', $pls);
    $this->db->update('pulsa', $data); // Untuk mengeksekusi perintah update data
  }
  

  public function delete($hrg){
    $this->db->where('detail_transaksi', $hrg);
    $this->db->delete('pulsa'); // Untuk mengeksekusi perintah delete data
  }
  public function tampil_data_chained($id){
	$query = $this->db->query("SELECT * FROM detail_transaksi where operator = '$opr'");
	return $query;
}

}