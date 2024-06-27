package com.backend_senac.healthcare.service;

import com.backend_senac.healthcare.domain.Faturamento;
import com.backend_senac.healthcare.domain.ItemFaturamento;
import com.backend_senac.healthcare.exceptions.RegistroNaoEncontradoException;
import com.backend_senac.healthcare.repository.ItemFaturamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemFaturamentoService {

    @Autowired
    private ItemFaturamentoRepository itemFaturamentoRepository;
    @Autowired
    private FaturamentoService faturamentoService;

    public ItemFaturamento salvar(ItemFaturamento itemFaturamento) {
        Faturamento faturamento = faturamentoService.buscarPorId(itemFaturamento.getFaturamento().getId());
        faturamento = faturamentoService.atualizarTotalFaturamento(faturamento, itemFaturamento.getValor());
        itemFaturamento.setFaturamento(faturamento);
        return itemFaturamentoRepository.save(itemFaturamento);
    }

    public ItemFaturamento alterar(Long id, ItemFaturamento itemFaturamento) {
        buscarPorId(id);
        itemFaturamento.setId(id);
        return salvar(itemFaturamento);
    }

    public ItemFaturamento buscarPorId(Long id) {
        return itemFaturamentoRepository.findById(id).orElseThrow(() ->
                new RegistroNaoEncontradoException("Item Faturamento com id " + id + " não encontrado"));
    }

    public void excluir(Long id) {
        buscarPorId(id);
        itemFaturamentoRepository.deleteById(id);
    }

    public List<ItemFaturamento> listarTodos() {
        return itemFaturamentoRepository.findAll();
    }
}
