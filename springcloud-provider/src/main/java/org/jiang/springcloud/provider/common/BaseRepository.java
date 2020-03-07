package org.jiang.springcloud.provider.common;

import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Description
 * @Author li.linhua
 * @Date 2020/3/7
 * @Version 1.0
 */
@NoRepositoryBean
public interface BaseRepository<T, ID> extends PagingAndSortingRepository<T, ID> {
}
