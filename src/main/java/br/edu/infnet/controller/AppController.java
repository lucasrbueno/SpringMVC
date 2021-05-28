package br.edu.infnet.controller;

import br.edu.infnet.model.negocio.Aluno;
import br.edu.infnet.model.repository.AlunoRepository;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
    
    @RequestMapping("/cadastrar") 
    public String cadastrar(Model model, Aluno aluno) throws SQLException{
        AlunoRepository ar = new AlunoRepository();
        ar.adicionar(aluno);
        return "redirect:/consulta";
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
    
    @RequestMapping("excluir")
    public String excluir(@RequestParam int id){
        AlunoRepository ar = new AlunoRepository();
        
        ar.excluir(id);
        return "redirect:/";
    }
    
    @RequestMapping("alterar")
    public ModelAndView alterar(@RequestParam int id){
        AlunoRepository ar = new AlunoRepository();
        ModelAndView mv = new ModelAndView("alterar");
        Aluno aluno = ar.consultarPorId(id);
        mv.addObject("aluno", aluno);
        ar.alterar(aluno);
        
        return mv;
    }
    
     @RequestMapping(name = "salvaraluno", method = RequestMethod.POST)
        public String salvarAluno(@ModelAttribute("aluno") Aluno aluno){
        AlunoRepository ar = new AlunoRepository();
        
        ar.alterar(aluno);
        return "redirect:/";
    }
}
