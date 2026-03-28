package com.mrbatista.jamesbeer.repository.helper.cidade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.mrbatista.jamesbeer.model.Cidade;
import com.mrbatista.jamesbeer.repository.filter.CidadeFilter;
import com.mrbatista.jamesbeer.repository.paginacao.PaginacaoUtil;

public class CidadesImpl implements CidadesQueries {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private PaginacaoUtil paginacaoUtil;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Page<Cidade> filtrar(CidadeFilter filtro, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Cidade.class);
		
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		criteria.setFirstResult(primeiroRegistroDaPagina);
		criteria.setMaxResults(totalRegistrosPorPagina);
		
		Sort sort = pageable.getSort();
		if(sort != null) {
			Sort.Order order = sort.iterator().next();
			String property = order.getProperty();
			criteria.addOrder(order.isAscending() ? Order.asc(property) : Order.desc(property));
		}
		
		paginacaoUtil.preparar(criteria, pageable);		
		adicionarFiltro(filtro, criteria);
		criteria.createAlias("estado", "e", JoinType.LEFT_OUTER_JOIN);
		criteria.setFetchMode("estado", FetchMode.JOIN);
		
		return new PageImpl<>(criteria.list(), pageable, total(filtro));
	}

	private void adicionarFiltro(CidadeFilter filtro, Criteria criteria) {
		if(filtro != null) {
			if(!StringUtils.isEmpty(filtro.getEstado())) {
				criteria.add(Restrictions.eq("estado", filtro.getEstado()));
			}
			
			if(!StringUtils.isEmpty(filtro.getNome())) {
				criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
			}
		}
	}
	
	private Long total(CidadeFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Cidade.class);
		adicionarFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

//	private boolean isEstadoPresente(CidadeFilter filtro) {
//		return filtro.getEstado() != null && filtro.getEstado().getCodigo() != null;
//	}

}
