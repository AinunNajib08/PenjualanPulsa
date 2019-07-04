<?php

use Illuminate\Database\Eloquent\Model;

class M_login extends Model
{
    protected $table = 'saldo';
    public $timestamps = false;
    protected $fillable = [
        'id_akun',
        'saldo',
        'username',
        'password'
    ];
}
