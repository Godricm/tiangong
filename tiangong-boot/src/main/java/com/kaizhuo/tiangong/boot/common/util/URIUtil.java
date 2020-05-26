package com.kaizhuo.tiangong.boot.common.util;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.common.util
 * @description:
 * @author: miaochen
 * @create: 2020-05-26 21:49
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public class URIUtil {
    public static String appendUri(String uri, String appendQuery) throws URISyntaxException {
        URI oldUri = new URI(uri);

        String newQuery = oldUri.getQuery();
        if (newQuery == null) {
            newQuery = appendQuery;
        } else {
            newQuery += "&" + appendQuery;
        }

        URI newUri = new URI(oldUri.getScheme(), oldUri.getAuthority(),
                oldUri.getPath(), newQuery, oldUri.getFragment());

        return newUri.toString();
    }
}
