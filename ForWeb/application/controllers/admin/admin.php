<?php

class Admin extends CI_Controller {

    function __construct() {
        parent::__construct();
        $this->load->helper('html');
    }

    public function index() {
        $this->load->view('admin/Dashboard');
    }

    
    }
    

