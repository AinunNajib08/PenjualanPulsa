<?php
$this->load->view('template/head');
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
} else {
    $this->load->view('template/sidebaradmin');
};
?>
<!-- Akhir sidebar admin -->
<?php
echo form_open('index.php/transaksi/add');
?>
<!-- Awal Dashboard admin -->
<div class="col-md-9">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title"><i class="fa fa-money"></i> Form Transaksi</h3>
                    </div>
                    <div class="panel-body">
                        <table class="table table-bordered">
                            <tr>
                                <th>Id Transaksi</th>
                                <th>Operator</th>
                                <th>Nominal</th>
                                <th>Harga Jual</th>
                                <th>No Tujuan</th>
                                <th>Cancel</th>
                            </tr>
                            <?php

                foreach($trans->result_array() as $id):

                $id_transaksi=$id['id_transaksi'];
                $operator=$id['operator'];
                $nominal=$id['nominal'];
                $harga_jual=$id['harga_jual'];
                $no_tujuan=$id['no_tujuan'];
                ?>
            <tr>

            <td><?php echo $id_transaksi;?> </td>
            <td><?php echo $operator;?> </td>
            <td><?php echo $nominal;?> </td>
            <td><?php echo $harga_jual;?> </td>
            <td><?php echo $no_tujuan;?> </td>
            </tr>

            <?php endforeach;?>
  </table>
                    </div>
                </div>
            </div>
        </div>
    </div>




    <!-- Akhir Coding Lihat Data -->
</div>
</div>
</div>
<!-- Akhir Dashboard admin -->
<!-- Awal footer -->


<script type="text/javascript">
    function otomatis() {
        var no_hp = $("#no_hp").val();
        $.ajax({
            type: 'GET',
            url: '<?php echo base_url() ?>index.php/transaksi/form_autocomplit',
            data: 'no_hp=' + no_hp,
            success: function (data) {
                var json = data,
                        obj = JSON.parse(json);
                $("#nama_nominal").val(obj.nama_nominal);
                $("#nama_kategori").val(obj.nama_kategori);
                $("#id_nominal").val(obj.id_nominal);
                $("#id_kategori").val(obj.id_kategori);
                $("#nama_proveder").val(obj.nama_proveder);
                $("#id_transaksi").val(obj.id_transaksi);

            }
        });
    }
</script>
<?php
$this->load->view('template/foot')
?>
<!-- Akhir footer -->