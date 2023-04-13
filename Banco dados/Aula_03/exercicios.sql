cliente(id, nome) 
produtos(id, nome)
vendas(id, data, id_cliente)
vendas_produtos(id_vendas, id_produto, quant, valor_unit)
formas_pgto(id, nome)
vendas_formas_pgto(id_venda, id_forma_pgto, valor, quantas_vezes)

--listar todos os produtos vendidos no mes de fevereiro

select p.nome as produto, sum(vp.qtd) as qtd_vendida,
       sum(vp.qtd * vp.valor_unit) as valor_total 
from vendas v
    join vendas_produtos vp
        on v.id = pv.venda_id
    join produtos p 
        on vp.produto_id = p.id 
where v.data>='2023-02-01' and v.data<='2023-02-28'        
group by p.nome
order by 

---- listar o valor total de vendas por forma de pagamento no mes de fev. 23

select f.nome as formas_pgto, coalesce(sum(vfp.valor),0) as total
from formas_pgto fp
    left join vendas_formas_pgto vfp
        on f.id = vfp.id_forma_pgto
    left join vendas v 
        on v.id = vfp.id_venda
where v.data>='2023-02-01' and v.data<='2023-02-28'           
group by f.nome

