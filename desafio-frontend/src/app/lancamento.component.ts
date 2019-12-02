import { Component, OnInit, ContentChild } from '@angular/core';
import { Router } from '@angular/router';
import { LancamentoService } from './lancamento.service';
import { Lancamento } from './lancamento';

@Component({
    templateUrl: './lancamento.component.html',
    styleUrls:['./lancamento.component.css']
})

export class LancamentoComponent implements OnInit {
    lancamentos: Lancamento[];
    lancamentoService: LancamentoService;
    config: any;
    totalSize:Number;
    popoverMessage:String = "Deseja realmente deletar?"

    constructor(lancamentoService: LancamentoService, private router: Router) {
           this.lancamentoService = lancamentoService;
    }

    ngOnInit() {
         this.getList();

        this.config = {
          itemsPerPage: 2,
          currentPage: 1,
          totalItems: this.totalSize
        };
    }

    getList(){
      this.lancamentoService.getLancamentoList()
      .subscribe(dados => {this.lancamentos = dados, this.totalSize = dados.length},
        erro => {console.log(erro.error.detail), this.router.navigate([''])});
    }

    delete(id) {
      this.lancamentoService.delete(id).subscribe(() => { this.getList();
        });
    }
    
    pageChanged(event){
      this.config.currentPage = event;
    }
}