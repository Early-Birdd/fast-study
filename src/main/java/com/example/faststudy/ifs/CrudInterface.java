package com.example.faststudy.ifs;

import com.example.faststudy.model.network.Header;
import com.example.faststudy.model.network.request.UserApiRequest;
import com.example.faststudy.model.network.response.UserApiResponse;

public interface CrudInterface<Req, Res> {

    Header<Res> create(Header<Req> request);

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> request);

    Header delete(Long id);
}
