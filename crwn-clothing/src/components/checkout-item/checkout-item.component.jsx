import './checkout-item.styles.scss';

import { selectCartItems } from '../../store/cart/cart.selector';
import { addItemToCart,  clearItemFromCart, removeItemToCart} from '../../store/cart/cart.action';
import { useSelector, useDispatch } from 'react-redux';

const CheckoutItem = ({cartItem}) => {
    const {name, imageUrl, price, quantity} = cartItem;
    const cartItems = useSelector(selectCartItems);
    const dispatch = useDispatch;

    const clearItemHandler = () => dispatch(clearItemFromCart(cartItems, cartItem));

    const addItemHandler = () => dispatch(addItemToCart(cartItems,cartItem));

    const removeItemHandler = () => dispatch(removeItemToCart (cartItems,cartItem));

    return (
        <div className='checkout-item-container'>
            <div className='image-container'>
                <img src={imageUrl} alt={`${name}`}></img>
            </div>
            <span className='name'>{name}</span>
            <span className='quantity'>
                <div className='arrow' onClick={removeItemHandler}>
                    &#10094;
                </div>
                <div className='value'>
                    {quantity}
                </div>
                <div className='arrow' onClick={addItemHandler}>
                    &#10095;
                </div>
                
            </span>
            <span className='price'>{price}</span>
            <div className='remove-button' onClick={clearItemHandler}>&#10005;</div>
        </div>
    )
}

export default CheckoutItem;