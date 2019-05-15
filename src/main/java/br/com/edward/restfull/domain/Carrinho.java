package br.com.edward.restfull.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;

@Getter

@Entity
@Table(name = "carrinho")
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(mappedBy = "carrinho", targetEntity = ItemCarrinho.class, cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<ItemCarrinho> itens;
    
    public Carrinho() {
        this.itens = new ArrayList<>();
    }
    
    public Double getTotal() {
        return this.itens.stream().mapToDouble(ItemCarrinho::getTotal).sum();
    }
    
    public void addItem(ItemCarrinho item) {
        this.itens.add(item);
    }
    
    public ItemCarrinho removerItem(Long id) {
        
        ItemCarrinho item = this.itens.stream().filter(x -> id.equals(x.getId())).findAny().orElse(null);
        if (Objects.nonNull(item)) {
            this.itens.remove(item);
        }
        return item;
    }
}
