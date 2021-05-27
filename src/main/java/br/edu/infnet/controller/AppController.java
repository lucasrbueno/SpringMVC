package br.edu.infnet.controller;

import br.edu.infnet.model.negocio.Aluno;
import br.edu.infnet.model.repository.AlunoRepository;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    
//    @RequestMapping("/aluno")
//    public String olaAluno(Model model, Aluno aluno){
//        AlunoRepository ar = new AlunoRepository();
//        
//        try{
//            ar.adicionar(aluno);
//            model.addAttribute("nome", aluno.getNome());
//        } catch(SQLException ex){
//            System.out.println(ex);
//        }
//        return "aluno";
//    }
    
    @RequestMapping("/cadastrar") 
    public String cadastrar(Model model, Aluno aluno) throws SQLException{
        AlunoRepository ar = new AlunoRepository();
        ar.adicionar(aluno);
        return "consulta";
    }
    
    @RequestMapping("/cadastro")
    public String cadastro(Model model){ 
        Aluno aluno = new Aluno();
        model.addAttribute("aluno", aluno);
        return "cadastro";
    }
    
    @RequestMapping("/consulta")
    public String consulta(Model model){
        AlunoRepository ar = new AlunoRepository();
        
        try {
            model.addAttribute("lista", ar.consultar());
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return "consulta";
    }
}
