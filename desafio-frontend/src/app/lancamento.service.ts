import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Lancamento } from './lancamento';

const API_URL = 'api/';

@Injectable({
    providedIn: 'root'
})
export class LancamentoService {

    constructor(private http: HttpClient) {}

    getLancamentoList(){
        return this.http.get<Lancamento[]>(API_URL + "v1/lancamentos");
    }

    delete(id:Number){
        return this.http.delete(API_URL + "v1/lancamentos/" + id, { responseType: 'text' });
    }

}