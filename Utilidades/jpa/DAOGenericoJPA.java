package jpa;

import javax.persistence.EntityManager;
import utilidades.JOPM;

public class DAOGenericoJPA<Gene> {

    private static EntityManager em;
    private Gene gene;
    
    public DAOGenericoJPA( Gene gene2, EntityManager em2 ) { try{
        
            gene = gene2;
            em = em2;
            
        } catch( Exception e ){ JOPM JOPM = new JOPM( 2, "DAOGenericoJPA( Gene gene2 ), \n"
                + e.getMessage() + "\n", "DAOGenericoJPA<Gene>" ); }
    }

    public void inserir() { try {                   
            
            em.getTransaction().begin();
            em.persist(gene);
            em.getTransaction().commit();
            em.close();
            
        } catch( Exception e ){ JOPM JOPM = new JOPM( 2, "inserir(), \n"
                + e.getMessage() + "\n", "DAOGenericoJPA<Gene>" ); } 
    }
    
    public void excluir(){ /*new Thread() {   @Override public void run() {*/ try { Thread.sleep( 1 );                   
                        
            em.getTransaction().begin();
            gene = em.merge( gene );
            em.remove( gene );
            em.getTransaction().commit();            
            em.close();   
            
        } catch( Exception e ){ JOPM JOPM = new JOPM( 2, "excluir, \n"
                + e.getMessage() + "\n", "DAOGenericoJPA<Gene>" ); } //} }.start();
    }

    public void atualizar(){ /*new Thread() {   @Override public void run() {*/ try { Thread.sleep( 1 );                   
            
            em.getTransaction().begin();
            em.refresh(gene);
            em.getTransaction().commit();
            em.close();  
            
        } catch( Exception e ){ JOPM JOPM = new JOPM( 2, "atualizar(), \n"
                + e.getMessage() + "\n", "DAOGenericoJPA<Gene>" ); } //} }.start(); 
    }

    public void gravanovoOUatualizar(){ /*new Thread() {   @Override public void run() {*/ try { Thread.sleep( 1 );                   
            
            em.getTransaction().begin();
            em.merge(gene);
            em.getTransaction().commit();
            em.close();   
            
        } catch( Exception e ){ JOPM JOPM = new JOPM( 2, "gravanovoOUatualizar(), \n"
                + e.getMessage() + "\n", "DAOGenericoJPA<Gene>" ); } //} }.start();
    }
    
    public venda.Venda gravanovoOUatualizarVenda( venda.Venda Venda ){ /*new Thread() {   @Override public void run() {*/ try { Thread.sleep( 1 );                   
                        
            em.getTransaction().begin();
            Venda = em.merge( Venda );
            em.getTransaction().commit();            
            em.close();   
            
        } catch( Exception e ){ JOPM JOPM = new JOPM( 2, "gravanovoOUatualizar(), \n"
                + e.getMessage() + "\n", "DAOGenericoJPA<Gene>" ); } //} }.start();
        return Venda;
    }
    
    /*
    public gestor.Gestordecompras gravanovoOUatualizarGestor( gestor.Gestordecompras Gestordecompras ){ new Thread() {   @Override public void run() { try { Thread.sleep( 1 );                   
                        
            em.getTransaction().begin();
            Gestordecompras = em.merge( Gestordecompras );
            em.getTransaction().commit();            
            em.close();   
            
        } catch( Exception e ){ JOPM JOPM = new JOPM( 2, "gravanovoOUatualizar(), \n"
                + e.getMessage() + "\n", "DAOGenericoJPA<Gene>" ); } } }.start();
        return Gestordecompras;
    }*/

    /*private List<Gene> re = null;
    public List lista_todos(){ new Thread() {   @Override public void run() { try { Thread.sleep( 1 );                   
                    
            Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.MATERIA", Materia.class );            
            List<Materia> todoList = q.getResultList();
            for (Materia Materia : todoList) {
                System.out.println(Materia.getId() + " - " + Materia.getMateria());
            }
            
        } catch( Exception e ){ JOPM JOPM = new JOPM( 2, "lista_todos(Query q), \n"
                + e.getMessage() + "\n", "DAOGenericoJPA<Gene>" ); } } }.start();   
        
         return re;       
    }*/

}