package ssu.db.BookShop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ssu.db.BookShop.dto.BooksInOrderDTO;
import ssu.db.BookShop.dto.BooksInOrderMapper;
import ssu.db.BookShop.entity.BooksInOrder;
import ssu.db.BookShop.repository.BooksInOrderRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BooksInOrderServiceImpl implements BooksInOrderService {

    private BooksInOrderRepository booksInOrderRepository;
    private BooksInOrderMapper booksInOrderMapper;

    @Override
    public List<BooksInOrderDTO> getAllBooksInOrder() {
        List<BooksInOrder> listBooksInOrder = booksInOrderRepository.findAll();
        List<BooksInOrderDTO> listBooksInOrderDTO = new ArrayList<>();
        for (BooksInOrder booksInOrder : listBooksInOrder) {
            listBooksInOrderDTO.add(booksInOrderMapper.booksInOrderToBooksInOrderDTO(booksInOrder));
        }
        return listBooksInOrderDTO;
    }

    @Override
    public void createBooksInOrder(BooksInOrderDTO booksInOrderDTO) {
        BooksInOrder booksInOrder = booksInOrderMapper.booksInOrderDTOToBooksInOrder(booksInOrderDTO);
        booksInOrderRepository.save(booksInOrder);
    }
}
