package ssu.db.BookShop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ssu.db.BookShop.dto.BooksInSupplyDTO;
import ssu.db.BookShop.dto.BooksInSupplyMapper;
import ssu.db.BookShop.entity.BooksInSupply;
import ssu.db.BookShop.repository.BooksInSupplyRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BooksInSupplyServiceImpl implements BooksInSupplyService{

    private BooksInSupplyRepository booksInSupplyRepository;
    private BooksInSupplyMapper booksInSupplyMapper;

    @Override
    public List<BooksInSupplyDTO> getAllBooksInSupply() {
        List<BooksInSupply> listBooksInSupply = booksInSupplyRepository.findAll();
        List<BooksInSupplyDTO> listBooksInSupplyDTO = new ArrayList<>();
        for (BooksInSupply booksInSupply : listBooksInSupply) {
            listBooksInSupplyDTO.add(booksInSupplyMapper.booksInSupplyToBooksInSupplyDTO(booksInSupply));
        }
        return listBooksInSupplyDTO;
    }

    @Override
    public void createBooksInSupply(BooksInSupplyDTO booksInSupplyDTO) {
        BooksInSupply booksInSupply = booksInSupplyMapper.booksInSupplyDTOToBooksInSupply(booksInSupplyDTO);
        booksInSupplyRepository.save(booksInSupply);
    }
}
