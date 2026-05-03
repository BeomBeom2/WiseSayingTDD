package com.back.domain.standard.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Pageable {
    private final int pageNo;
    private final int pageSize;

    public Pageable(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }
    public long getSkipCount() {
        return (pageNo - 1) * pageSize;
    }
}
