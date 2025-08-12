package com.example.tour.tour;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TourService {

    private final TourRepository repository;

    public TourService(TourRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Tour create(Tour tour) {
        
        int actual = parsePriceToInt(tour.getActualPrice());
        int discounted = parsePriceToInt(tour.getDiscountedPrice());
        if (discounted > actual) {
            throw new IllegalArgumentException("discountedPrice cannot be greater than actualPrice");
        }
        tour.setActualPriceValue(actual);
        tour.setDiscountedPriceValue(discounted);
        return repository.save(tour);
    }

    @Transactional(readOnly = true)
    public java.util.List<Tour> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Tour findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tour with id " + id + " not found"));
    }

    private int parsePriceToInt(String price) {
        if (price == null) throw new IllegalArgumentException("Price cannot be null");
        
        String digits = price.replaceAll("[^0-9]", "");
        if (digits.isEmpty()) throw new IllegalArgumentException("Price format invalid: " + price);
        return Integer.parseInt(digits);
    }
}
