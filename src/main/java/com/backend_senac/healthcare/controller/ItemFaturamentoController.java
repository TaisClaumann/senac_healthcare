package com.backend_senac.healthcare.controller;

import com.backend_senac.healthcare.domain.ItemFaturamento;
import com.backend_senac.healthcare.domain.dto.ItemFaturamentoDto;
import com.backend_senac.healthcare.service.ItemFaturamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens-faturamento")
public class ItemFaturamentoController {

    @Autowired
    private ItemFaturamentoService itemFaturamentoService;

    @PostMapping
    public ItemFaturamentoDto salvar(@RequestBody ItemFaturamento itemFaturamento) {
        return new ItemFaturamentoDto(itemFaturamentoService.salvar(itemFaturamento));
    }

    @PutMapping("/{id}")
    public ItemFaturamentoDto alterar(@RequestBody ItemFaturamento itemFaturamento, @PathVariable("id") Long id) {
        return new ItemFaturamentoDto(itemFaturamentoService.alterar(id, itemFaturamento));
    }

    @GetMapping("/{id}")
    public ItemFaturamentoDto buscarPorId(@PathVariable("id") Long id) {
        return new ItemFaturamentoDto(itemFaturamentoService.buscarPorId(id));
    }

    @GetMapping
    public List<ItemFaturamentoDto> listarTodos() {
        return itemFaturamentoService.listarTodos().stream().map(ItemFaturamentoDto::new).toList();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        itemFaturamentoService.excluir(id);
    }
}
