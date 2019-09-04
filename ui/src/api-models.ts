export interface EncryptRequest {
    secret: string;
    toEncrypt: string;
}

export interface DecryptRequest {
    secret: string;
    toDecrypt: string;
}

export interface LoginRequest {
    username: string;
    password: string;
    useRadiusAuthentication: boolean;
    connectionNumber: number;
}

export interface LoginResult {
    CyberArkLogonResult: string;
}

export interface GetSafesResult {
    Description: string;
    ManagingCPM: string;
    NumberOfVersionsRetention: number;
    OLACEnabled: boolean;
    SafeName: string;
}

export interface SafeResults {
    GetSafesResult: GetSafesResult[];
}

export interface InternalProperty {
    Key: string;
    Value: string;
}

export interface Property {
    Key: string;
    Value: string;
}

export interface Account {
    AccountID: string;
    InternalProperties: InternalProperty[];
    Properties: Property[];
}

export interface AccountDetails {
    Count: number;
    accounts: Account[];
}

export interface CredentialRequest {
    secret: string;
    accountId: string;
}

export interface PropValues {
    Safe: string;
    UserName: string;
    Address: string;
    Password: string;
}