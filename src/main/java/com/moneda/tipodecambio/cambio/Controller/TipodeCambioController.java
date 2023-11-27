package com.moneda.tipodecambio.cambio.Controller;


import com.moneda.tipodecambio.cambio.Model.MonedaModel;
import com.moneda.tipodecambio.cambio.Model.RequestActualizarDivisa;
import com.moneda.tipodecambio.cambio.Model.RequestCambio;
import com.moneda.tipodecambio.cambio.Model.ResponseCambio;
import com.moneda.tipodecambio.cambio.Service.TipoDeCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/divisa")
public class TipodeCambioController {

    @Autowired
    TipoDeCambioService tipodeCambioService;

    @PostMapping("")
    private ResponseCambio divisa(@RequestBody RequestCambio cambio){
        return tipodeCambioService.cambioMoneda(cambio);
    }

    @PostMapping("/actualizar")
    private MonedaModel actualizarDivisa(@RequestBody RequestActualizarDivisa requestActualizarDivisa){
        return tipodeCambioService.actualizarDivisa(requestActualizarDivisa);
    }

}
