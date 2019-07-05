<?php
$this->load->view('template/head');
$rand = rand(10, 100000);
?>
<!-- CSS -->
<!--tambahkan custom css disini-->
<!-- iCheck -->
<link rel="stylesheet" href="<?php echo base_url('assets/css/bootstrap.min.css') ?>">
  <script src="<?php echo base_url('assets/js/jquery.min.js') ?>" type="text/javascript"></script>
  <script src="<?php echo base_url('assets/js/popper.min.js') ?>" type="text/javascript"></script>
  <script src="<?php echo base_url('assets/js/bootstrap.min.js') ?>" type="text/javascript"></script>
  <link rel="stylesheet" type="text/css" href="style.css">
<!-- Akhir CSS -->

<!-- Awal sidebar admin -->
<?php
if ($this->session->userdata('level') == "karyawan") {
    $this->load->view('template/sidebar');
    }
    else {
    $this->load->view('template/sidebaradmin');
    };
?>
<!-- Akhir sidebar admin -->
<!--Hak akses-->

<!--Akhir hak akses-->
<!-- Awal Dashboard admin -->


<div class="col-md-9">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title"><i class="fa fa-cart-plus"></i> Form Beli Paketan</h3>
        </div>
               <?php  echo form_open('index.php/pembelian/post') ?>
   
        <div class="panel-body">
            <!-- Awal panel -->
            <!-- Awal Coding Lihat Data -->
            <table class="table table-striped">
          <tr><td width="130">Transaksi</td>
                  <td><div class="col-sm-4">
                  <input type="text" name="input_id" class="form-control" placeholder="Id Transaksi" value="<?php echo $rand; ?>">
                  <!-- <button type="submit" class="btn btn-primary btn-sm" name="submit">+</button> -->
                  </div>
                 </td></tr>
                 <tr>
                     <td width="135">Tanggal Transaksi</td>
                  <td><div class="col-sm-4">
                        <input type="date" name="input_tanggal" class="form-control" placeholder="Pilih Tangal">
              
                      </div>
                 </td></tr>
                 <tr><td width="130">Operator</td>
                  <td><div class="col-sm-4">
                    <select required name="input_nama_operator"class="form-control" placeholder="Pilih Operator">
        	        <option value="" disable diselected>Pilih Operator</option>
                    <?php                                
                foreach ($paketan as $row) {  
                    echo "<option value='".$row->id."'>".$row->nama_operator."</option>";
                }
                echo"
		</select>"
		?>
    </div>
    <tr><td width="130">Kuota Paketan</td>
                  <td><div class="col-sm-4">
                    <select required name="input_nama_operator"class="form-control" placeholder="Pilih Paket">
        	        <option value="" disable diselected>Pilih Paket</option>
                    <?php                                
                foreach ($paketan as $row) {  
                    echo "<option value='".$row->id."'>".$row->kuota_paketan."</option>";
                }
                echo"
		</select>"
		?>
    </div>
                   <!-- <input type="text" name="input_operator" class="form-control" placeholder="Operator"> -->
                    </div>
                 <tr><td width="130">Harga Jual</td>
                  <td><div class="col-sm-4">
                  <select required name="input_harga"class="form-control" placeholder="Harga">
        	        <option value="" disable diselected>Detail Harga</option>
                    <?php                                
                foreach ($paketan as $row) {  
                    echo "<option value='".$row->id."'>".$row->harga."</option>";
                }
                echo"
		    </select>"
		?> 
                  </div>
                  </td></tr>
                  <tr><td width="130">No Tujuan</td>
                  <td><div class="col-sm-4">
                  <input type="text" name="input_no_tujuan" class="form-control" placeholder="No Tujuan">
                  </div>
                 </td></tr>
              <tr><td colspan="2"><button type="submit" class="btn btn-primary btn-sm" name="submit">Simpan</button>
                  <?php echo anchor('index.php/pembelian','Kembali',array('class'=>'btn btn-primary btn-sm'))?>
                  </td></tr>
          </table>
            <?php echo form_close(); ?>

<!--           <div class="col-md-13">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="fa fa-money"></i> Detail Transaksi Pembelian</h3>
                    </div>
                    <div class="panel-body">
                            <table class="table table-bordered">
            <tr>
                <th>Id</th>
                <th>Operator</th>
                <th>Nominal</th>
                <th>Harga Jual</th>
                <th>Cancel</th>
            </tr>
            <tr>
                <?php 
                $total=0;
                $no=1;
                foreach ($detail_transaksi as $row): 
                ?>
                <td><?php echo $row->id_transaksi; ?></td>
                <td><?php echo $row->operator; ?></td>
                <td><?php echo $row->nominal; ?></td>
                <td><?php echo $row->harga_jual; ?></td>
               <td><?php echo $total=$row->qty*$row->harga_pokok; ?> 
                <td><?php echo anchor('index.php/pembelian/cancel/'.$row->id,'Cancel', array('class' => 'btn btn-danger')) ?></td>
                 </tr>
                    <?php $no++; ?>
                

                <?php endforeach; ?>
           
          </table>
      
                    </div>
                </div>
            </div>
        </div>
    </div>

-->

    <!-- Akhir Coding Lihat Data -->
</div>
</div>
</div>
<?php
$this->load->view('template/foot')
?>
<!-- Akhir footer -->