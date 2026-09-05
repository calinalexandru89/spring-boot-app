import {
    Button,
    Drawer,
    DrawerOverlay,
    DrawerBody,
    DrawerContent,
    DrawerFooter,
    useDisclosure,
    Input,
    DrawerCloseButton,
    DrawerHeader
} from "@chakra-ui/react";
import CreateCustomerForm from "./CreateCustomerForm.jsx"

const AddIcon = () => "+";
const CloseIcon = () => "x";

const DrawerForm = ({fetchCustomers }) => {
    const { isOpen, onOpen, onClose } = useDisclosure()

    return<>
        <Button leftIcon={<AddIcon/>} onClick={onOpen} colorScheme={"teal"}>
            Create customer
        </Button>
        <Drawer isOpen={isOpen} onClose={onClose} size={"xl"}>
            <DrawerOverlay />
            <DrawerContent>
                <DrawerCloseButton />
                <DrawerHeader>Create new customer</DrawerHeader>

                <DrawerBody>
                    <CreateCustomerForm
                    fetchCustomers={fetchCustomers}
                    />
                </DrawerBody>

                <DrawerFooter>
                    <Button leftIcon={<CloseIcon/>} onClick={onClose} colorScheme={"teal"}>
                        Close
                    </Button>
                </DrawerFooter>
            </DrawerContent>
        </Drawer>
    </>
}

export default DrawerForm;
