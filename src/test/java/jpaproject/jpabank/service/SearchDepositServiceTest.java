package jpaproject.jpabank.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SearchDepositServiceTest {
    @Autowired SearchDepositRepository searchDepositRepository;
    @Autowired SearchDepositService searchDepositService;

    @Test
    public void 조건등록() throws Exception{
        //given
        Search_Deposit search_deposit = new Search_Deposit();
        search_deposit.setMoney_deposit(10000L);

        //when
        Long Id = searchDepositService.join(search_deposit);

        //then
        assertEquals(search_deposit, searchDepositRepository.findOne(Id));

        }




}