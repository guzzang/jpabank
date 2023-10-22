package jpaproject.jpabank.api;

import jpaproject.jpabank.domain.dto.DepositResultDto;
import jpaproject.jpabank.domain.dto.DepositResultDto2;
import jpaproject.jpabank.domain.dto.DepositSearchCondition;
import jpaproject.jpabank.domain.dto.ResultUrlDto;
import jpaproject.jpabank.domain.repository.ItemJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // React 앱의 도메인 및 포트로 수정
@RequiredArgsConstructor
public class SearchDepositController {

    private final ItemJpaRepository itemJpaRepository;

    // 상품 전체 조회 (우대 조건 미포함)
    @GetMapping("/v1/all-deposits")
    public List<DepositResultDto> searchDepositV1(){
        return itemJpaRepository.searchAll();
    }

    // 상품 전체 조회 (우대 조건 포함)
    @GetMapping("/v2/all-deposits")
    public List<DepositResultDto2> searchDepositV2(){
        return itemJpaRepository.searchAll2();
    }


    // 상품 조건 선택 후 조회 (우대 조건 미포함)
    @GetMapping("/v1/search-deposits") // HTTP method를 통해 행위 명시, url은 가능하면 검색할 자원을 명시할 것
    public List<DepositResultDto> searchDepositV3(DepositSearchCondition depositSearchCondition){
        return itemJpaRepository.search1(depositSearchCondition);
    }


    // 상품 조건 선택 후 조회 (우대 조건 포함)
    @GetMapping("/v2/search-deposits") // HTTP method를 통해 행위 명시, url은 가능하면 검색할 자원을 명시할 것
    public List<DepositResultDto2> SearchDepositV4(DepositSearchCondition depositSearchCondition){
        return itemJpaRepository.search2(depositSearchCondition);
    }

    @GetMapping("/v1/search-url") // HTTP method를 통해 행위 명시, url은 가능하면 검색할 자원을 명시할 것
    public List<ResultUrlDto> searchUrl(DepositSearchCondition depositSearchCondition){
        return itemJpaRepository.searchUrl(depositSearchCondition);
    }

    @PostMapping("/v3/search-deposits")
    public List<DepositResultDto> searchDepositV5(@RequestBody DepositSearchCondition depositSearchCondition){
        return itemJpaRepository.search1(depositSearchCondition);
    }

    @PostMapping("/v4/search-deposits")
    public List<DepositResultDto2> SearchDepositV6(@RequestBody DepositSearchCondition depositSearchCondition){
        return itemJpaRepository.search2(depositSearchCondition);
    }
}
