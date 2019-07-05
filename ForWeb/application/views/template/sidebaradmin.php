<div class=".container-fluid" style="margin-top: 80px">
    <div class="row">
        <div class="col-md-3">
            <div class="list-group">
              <a href="#" class="list-group-item active" style="text-align: center;background-color: green;border-color: black">
                MENU
              </a>
               <!-- User Panel -->
              <div class="user-panel">
                <div class="pull-left image">
                <img src="<?php echo base_url('assets/AdminLTE-2.0.5/dist/img/avatar7.png') ?>" class="img-circle" alt="User Image" />
                </div>
                  <div class="pull-left info">
                <p><b><?php echo $this->session->userdata('username'); ?></b></p>
                    <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div>
            <!--Coba sidebar-->
            
            <!--Akhir sidebar coba-->

              <!-- Akhir User Panel-->
              <a href="<?php echo base_url() ?>index.php/pembelian" class="list-group-item"><i class="fa fa-cart-plus"></i> Beli Pulsa</a>
              <a href="<?php echo base_url() ?>index.php/transaksi" class="list-group-item"><i class="fa fa-money"></i> Detail Transaksi</a>
            </div>
        </div>
