package projet.spring.boot.springpredicate.rest.ressource;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import projet.spring.boot.springpredicate.service.IEtudiant;
import projet.spring.boot.springpredicate.service.dto.EtudiantDTO;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/*")
public class EtudiantController {
    private IEtudiant iEtudiant;

    public EtudiantController(IEtudiant iEtudiant) {
        this.iEtudiant = iEtudiant;
    }

    @GetMapping("etudiants")
    public List<EtudiantDTO>serache(
            @RequestParam(required = false)Integer pageNumber,
            @RequestParam(required = false)Integer pageSize,
            @RequestParam(required = false)String nom,
            @RequestParam(required = false)String prenom,
            @RequestParam(required = false)Boolean active,
            @RequestParam(required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateNaissance
            ){
        return iEtudiant.search(pageNumber,pageSize,nom,prenom,active,dateNaissance);
    }
}
