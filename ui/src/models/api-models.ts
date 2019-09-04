export interface EncryptRequest {
    secret: string;
    toEncrypt: string;
}

export interface DecryptRequest {
    secret: string;
    toDecrypt: string;
}