package com.task.task.Service;

import com.task.task.Model.BaseEntity;
import com.task.task.Model.Dto.common.BaseEntityDto;
import com.task.task.Model.Dto.search.forms.BaseSearchForm;
import com.task.task.Model.Dto.common.PageDto;
import com.task.task.common.BusinessException;
import com.task.task.dao.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Alaa Yehia
 * @implNote this base service have All shared methods and keep many if concepts like
 * single responsibility principle and Dry principle and so on
 * @param <T>  T is entity
 * @param <D> D is Dto
 * @param <Z> Z is search form
 */

public abstract class BaseService<T extends BaseEntity,D extends BaseEntityDto,Z extends BaseSearchForm> {

    protected GenericRepository<T> genericRepository;

    public BaseService(GenericRepository<T> genericRepository) {
        this.genericRepository = genericRepository;
    }

    /**
     * @implNote
     * {@code toEntity method  to convert dto to entity  }
     * @code {toDto method to convert entity to dto }
     * @code {toListOfDto method to covert list of entity to dto  }
     */

    protected abstract T toEntity(D object);

    protected abstract D toDto(T object);

    protected abstract List<D> toListOfDto(List<T> list);


    /**
     * @implNote these methods for user to add actions before or after create method or update method or delete method
     */
    protected void actionBeforeCreate(T entity){
    }

    protected  void actionAfterCreate(T entity){
    }

    protected void actionBeforeUpdate(T entity){
    }

    protected  void actionAfterUpdate(T entity){
    }

    protected void actionBeforeDelete(long id){
    }

    protected  void actionAfterDelete(long id){
    }



    public D getById(long id){
        Optional<T> optional=this.genericRepository.findById(id);
        if(optional.isPresent())
            return toDto(optional.get());
        else throw new BusinessException("NOT_FOUND");
    }

    public D create(D dto){
        T entity=toEntity(dto);
        actionBeforeCreate(entity);
        saveEntity(entity);
        actionAfterCreate(entity);
        dto = toDto(entity);
        return dto;
    }

    public D update(D dto){
        T entity=toEntity(dto);
        actionBeforeUpdate(entity);
        saveEntity(entity);
        actionAfterUpdate(entity);
        dto = toDto(entity);
        return dto;
    }


    public void delete(long id){
        actionBeforeDelete(id);
        this.genericRepository.deleteById(id);
        actionAfterDelete(id);
    }


    /**
     * @implNote this method for built search with specification
     * @param searchParams search form for doSearch
     */
    protected abstract Specification<T> buildSpecification(Z searchParams);

    /**
     * @implNote this method for build page request to return list as pages
     */
    protected PageRequest buildPageRequest(Z searchForm){
        if(searchForm.getPage() > 0)
            searchForm.setPage(searchForm.getPage() -1);
    return PageRequest.of(searchForm.getPage(),searchForm.getSize());
    }

    /**
     * @implNote here we build page dto to set data and number of pages and number of elements
     */
    protected PageDto buildPageDto(Page<T> page){
    PageDto pageDto=new PageDto();
    if(Objects.nonNull(page)){
        pageDto.setTotalPage(page.getTotalPages());
        pageDto.setTotalElements(page.getTotalElements());
        pageDto.setData(page.getContent());
    }
    return pageDto;
    }

    /**
     * @implNote this method for return list of elements with pages
     */
    protected Page<T> findEntityPageBySpecifications(Z searchForm){
    Page<T> pages=null;
    Specification<T> specification=buildSpecification(searchForm);
    if(Objects.nonNull(specification) && Objects.nonNull(searchForm.getPage()) && Objects.nonNull(searchForm.getSize()))
        pages=genericRepository.findAll(specification,buildPageRequest(searchForm));
    return pages;
    }

    public PageDto findListWithPagination(Z searchForm){
    Page<T> page=findEntityPageBySpecifications(searchForm);
    return buildPageDto(page);
    }

    /**
     * @implNote this method for search without pagination
     */
    public List<D> searchEntity(Z searchForm){
    Specification<T> specification=buildSpecification(searchForm);
     return toListOfDto(genericRepository.findAll(specification));
    }

    protected void saveEntity(T entity){
        genericRepository.save(entity);
    }

}
