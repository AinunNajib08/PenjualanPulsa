<!DOCTYPE html>
<html>
    <head>
        <title> Sistem Informasi Penjualan Pulsa</title>
        <link rel="stylesheet" href="<?php echo base_url('assets/css/bootstrap.min.css') ?>">
        <script src="<?php echo base_url('assets/js/jquery.min.js') ?>" type="text/javascript"></script>
        <script src="<?php echo base_url('assets/js/popper.min.js') ?>" type="text/javascript"></script>
        <script src="<?php echo base_url('assets/js/bootstrap.min.js') ?>" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar"></button>
                    <a class="navbar-brand"><h4><b>Aplikasi SMS Gateway By:</b></h4></a>
                    <marquee behavior="scroll" scrollamount="15" direction="left" width="900">
                        <h3><p class="black">The Hoax Team</p></h3>
                    </marquee>
                </div>
            </div>
        </nav>
        <!--Awal panel-->
        <div class="container">
            <div class="panel-group">
                <div class="panel panel-primary">
                    <div class="panel-heading"><h4><center>Selamat Datang di The Hoax SMS</center></h4></div>
                    <div class="panel-body"></div>
                    <!--Awal nav-tabs-->
                    <div class="container">
                        <ul class="nav nav-tabs">
                            <li class="active"><a data-toggle="tab" href="#home">Free SMS</a></li>
                        </ul>
                        <div class="tab-content">
                            <div id="home" class="tab-pane fade in active">
                                <!--Awal form input-->
                                <div class="container">
                                    <?php echo form_open('biling/add') ?>
                                    <div class="form-group row">
                                        <div class="col-xs-2">
                                        <label for="to">To :</label> <br/>
                                        <input type="text" id="to"/> <br/> 
                                        <label for="message">Message :</label> <br/>
                                        <textarea id="message" cols="20" rows="5"></textarea> <br/>
                                        <button id="send">Send SMS</button><br/><br/> 
                                        <label for="log">Log</label> <br/>
                                        <textarea id="log" cols="50" rows="5"></textarea> <br/>
                                        </div>
                                    </div>
                                </div>
                                <script type="text/javascript" src="app.js"></script>
                                </body>
                                </html>