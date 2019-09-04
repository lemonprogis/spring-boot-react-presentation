import axios from 'axios';
import {DecryptRequest, EncryptRequest} from "./api-models";

export default class ApiClientService {
    encryptValue = (encryptRequest: EncryptRequest): Promise<string> => {
        const url = `/api/encrypt`;

        return new Promise((resolve, reject) => {
            axios.post(url, encryptRequest)
                .then(({ status, data} ) => {
                    if (status === 200) {
                        resolve(data);

                    } else {
                        reject(new Error('error fetching data.'));
                    }
                });
        });
    };

    decryptValue = (decryptRequest: DecryptRequest):  Promise<string> => {
        const url = `/api/decrypt`;

        return new Promise((resolve, reject) => {
            axios.post(url, decryptRequest)
                .then(({ status, data} ) => {
                    if (status === 200) {
                        resolve(data);

                    } else {
                        reject(new Error('error fetching data.'));
                    }
                });
        });
    };
}