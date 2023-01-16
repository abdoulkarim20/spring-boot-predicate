package projet.spring.boot.springpredicate.rest.ressource;

import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import projet.spring.boot.springpredicate.repositorie.EtudiantRepository;
import projet.spring.boot.springpredicate.service.EtudiantService;
import projet.spring.boot.springpredicate.service.dto.EtudiantDTO;
import projet.spring.boot.springpredicate.service.dto.EtudiantDepartementDTO;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/*")
public class EtudiantController {
    private EtudiantService etudiantService;
    private final EtudiantRepository etudiantRepository;

    public EtudiantController(EtudiantService etudiantService,
                              EtudiantRepository etudiantRepository) {
        this.etudiantService = etudiantService;
        this.etudiantRepository = etudiantRepository;
    }

    @GetMapping("etudiants")
    public Page<EtudiantDTO> serache(
            @RequestParam(value = "pageNumber",defaultValue = "0")Integer pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
            @RequestParam(required = false)String nom,
            @RequestParam(required = false)String prenom,
            @RequestParam(required = false)Boolean active,
            @RequestParam(required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateNaissance,
            @RequestParam(required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateStart,
            @RequestParam(required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateEnd
            ){
        return etudiantService.search(pageNumber,pageSize,nom,prenom,active,dateNaissance,dateStart,dateEnd);
    }
    @PostMapping("etudiants")
    public EtudiantDTO save(@RequestBody EtudiantDTO etudiantDTO){
        return etudiantService.save(etudiantDTO);
    }
    @GetMapping("etudiants/filter")
    public Page<EtudiantDepartementDTO>getAllEtudiantByFiler(
            @RequestParam(defaultValue = "0")int page,
            @RequestParam(defaultValue = "5")int size,
            @RequestParam(required = false) String libelle
    ){
        return etudiantService.getAllEtudiantByFilter(page,size,libelle);
    }
}
