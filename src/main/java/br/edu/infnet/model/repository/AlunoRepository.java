package br.edu.infnet.model.repository;

import Conexao.Conexao;
import br.edu.infnet.model.negocio.Aluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

public class AlunoRepository {
    
    public EntityManager getEM(){
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringMVC1_PU");
        return factory.createEntityManager();
    }
    
    public void adicionar(Aluno aluno) throws SQLException{
        EntityManager em = getEM();
        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Aluno> consultar() throws SQLException{
        EntityManager em = getEM();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Aluno.class));
        
        List<Aluno> lista = em.createQuery(cq).getResultList();
        return lista;
    }
    
    public void excluir(int id){
        EntityManager em = getEM();
        Aluno aluno = em.find(Aluno.class, id);
        em.getTransaction().begin();
        em.remove(aluno);
        em.getTransaction().commit();
        em.close();
    }
    
    public Aluno consultarPorId(int id){
        EntityManager em = getEM();
        Aluno aluno = em.find(Aluno.class, id);
        
        return aluno;
    }
    
    public void alterar(Aluno aluno){
        EntityManager em = getEM();

        if(em.find(Aluno.class, aluno.getId()) == null){
            System.out.println("Erro: Não alterado");
            return;
        }    
        em.getTransaction().begin();
        em.merge(aluno);
        em.getTransaction().commit();
        em.close();
    }
}
