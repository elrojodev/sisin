import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';
import { ReactiveFormsModule, FormControl, FormGroup, Validators } from '@angular/forms';
import { InputRowComponent } from 'app/common/input-row/input-row.component';
import { ProductoService } from 'app/producto/producto.service';
import { ProductoDTO } from 'app/producto/producto.model';
import { ErrorHandler } from 'app/common/error-handler.injectable';


@Component({
  selector: 'app-producto-add',
  standalone: true,
  imports: [CommonModule, RouterLink, ReactiveFormsModule, InputRowComponent],
  templateUrl: './producto-add.component.html'
})
export class ProductoAddComponent implements OnInit {

  productoService = inject(ProductoService);
  router = inject(Router);
  errorHandler = inject(ErrorHandler);

  proAmrValues?: Map<number,string>;
  proTpoIdoValues?: Map<number,string>;

  addForm = new FormGroup({
    proNumeroParte: new FormControl(null, [Validators.required, Validators.maxLength(45)]),
    proNombre: new FormControl(null, [Validators.required, Validators.maxLength(45)]),
    proNumeroParteAlterno: new FormControl(null, [Validators.maxLength(45)]),
    proNumeroSerie: new FormControl(null, [Validators.maxLength(45)]),
    proUnidades: new FormControl(null, [Validators.required]),
    proFechaVencimiento: new FormControl(null, [Validators.required]),
    proTipoDocumento: new FormControl(null),
    proAmr: new FormControl(null, [Validators.required]),
    proTpoIdo: new FormControl(null, [Validators.required])
  }, { updateOn: 'submit' });

  getMessage(key: string, details?: any) {
    const messages: Record<string, string> = {
      created: $localize`:@@producto.create.success:Producto was created successfully.`,
      PRODUCTO_PRO_NUMERO_PARTE_ALTERNO_UNIQUE: $localize`:@@Exists.producto.proNumeroParteAlterno:This Pro Numero Parte Alterno is already taken.`,
      PRODUCTO_PRO_NUMERO_SERIE_UNIQUE: $localize`:@@Exists.producto.proNumeroSerie:This Pro Numero Serie is already taken.`
    };
    return messages[key];
  }

  ngOnInit() {
    this.productoService.getProAmrValues()
        .subscribe({
          next: (data) => this.proAmrValues = data,
          error: (error) => this.errorHandler.handleServerError(error.error)
        });
    this.productoService.getProTpoIdoValues()
        .subscribe({
          next: (data) => this.proTpoIdoValues = data,
          error: (error) => this.errorHandler.handleServerError(error.error)
        });
  }

  handleSubmit() {
    window.scrollTo(0, 0);
    this.addForm.markAllAsTouched();
    if (!this.addForm.valid) {
      return;
    }
    const data = new ProductoDTO(this.addForm.value);
    this.productoService.createProducto(data)
        .subscribe({
          next: () => this.router.navigate(['/productos'], {
            state: {
              msgSuccess: this.getMessage('created')
            }
          }),
          error: (error) => this.errorHandler.handleServerError(error.error, this.addForm, this.getMessage)
        });
  }

}
