import * as React from "react";
import {
    Button,
    Container,
    Divider,
    Grid,
    Header,
    Input,
    InputOnChangeData,
    Segment
} from "semantic-ui-react";
import ApiClientService from "../../api-client-service";
import {EncryptRequest} from "../../api-models";

interface PageProps {
}

interface PageState {
    password: string;
    secret: string;
    encryptedValue: string;
}

class MainPage extends React.Component<PageProps, PageState> {

    private client: ApiClientService;

    constructor(props: PageProps, state: PageState) {
        super(props, state);

        this.client = new ApiClientService();

        this.state = {
            password: '',
            secret: '',
            encryptedValue: ''
        }
    }

    handleChange = (event: React.SyntheticEvent<HTMLInputElement>, data: InputOnChangeData) => {

        this.setState({
            ...this.state,
            [data.name]: data.value});
    };

    handleGetPasswordClick = (event: any) => {
        const encryptRequest: EncryptRequest = {
            secret: this.state.secret,
            toEncrypt: this.state.password
        };

        this.client.encryptValue(encryptRequest)
            .then( (response: string) => {                
                this.setState({encryptedValue: response});
            });
    };


    public render() {
        return (
            <Container>
                <Grid>
                    <Grid.Row>
                        <Grid.Column computer={16}>
                            <Header as={"h1"} textAlign={"center"}>
                                Password Encryption Service
                            </Header>
                            <Divider/>
                        </Grid.Column>
                    </Grid.Row>
                    <Grid.Row>
                        <Grid.Column computer={16}>
                            <Segment.Group>
                                <Segment>Enter Secret to be used for encryption</Segment>
                                <Segment.Group>
                                    <Input type={'password'} name={'secret'} id={'secret'} fluid={true} onChange={this.handleChange}/>
                                </Segment.Group>
                                <Segment>Enter Password to Encrypt</Segment>
                                <Segment.Group>
                                    
                                    <Input type={"password"} name={"password"} id={"password"} onChange={this.handleChange} fluid={true} />

                                </Segment.Group>
                                <Segment>
                                    <Button content={"Encrypt Credential"} key={"fetchPassword"} onClick={this.handleGetPasswordClick} />
                                </Segment>
                            </Segment.Group>
                            <Segment color={"red"}>
                                <Header as={"h2"}>Values encrypted</Header>
                                <p>{this.state.encryptedValue}</p>
                            </Segment>
                        </Grid.Column>
                    </Grid.Row>
                </Grid>
            </Container>
        );
    }
}

export default MainPage;